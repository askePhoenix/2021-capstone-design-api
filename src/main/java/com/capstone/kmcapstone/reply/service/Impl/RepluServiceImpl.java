package com.capstone.kmcapstone.reply.service.Impl;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.reply.dto.ReplyDto;
import com.capstone.kmcapstone.reply.dto.ReplyVIewDto;
import com.capstone.kmcapstone.reply.model.ReplyInfo;
import com.capstone.kmcapstone.reply.repository.ReplyRepository;
import com.capstone.kmcapstone.reply.service.ReplyService;
import com.capstone.kmcapstone.user.model.UserInfo;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RepluServiceImpl implements ReplyService {
    private final ReplyRepository repository;
    private final BoardDetailRepository boardDetailRepository;

    // 댓글 생성하기
    @Override
    public ReplyDto createReply(Long target_board, UserInfo userInfo, ReplyVIewDto vIewDto) {
        try {
            BoardPageInfo board = boardDetailRepository.searchById(target_board).orElseThrow(NullPointerException::new);
            ReplyInfo info = repository.save(
                    ReplyInfo.builder()
                            .writer(userInfo)
                            .target_board(board)
                            .target_reply(vIewDto.getTarget_reply_id() != null  ?
                                    repository.searchByID(vIewDto.getTarget_reply_id()) : null)
                            .message(vIewDto.getMessage())
                            .build()
            );
            return new ReplyDto(info);
        } catch (NullPointerException e) {
            // 참조하는 보드가 없다면 -1L 키를 가진 빈 댓글 반환
            return new ReplyDto(ReplyInfo.builder().id(-1L).build());
        }
    }

    // 게시글 댓글 전부 가져오기
    @Override
    public List<ReplyDto> getReplys(Long target_board) {
        BoardPageInfo board = boardDetailRepository.searchById(target_board).orElseGet(
                () -> BoardPageInfo.builder().id(-1L).build()
        );
        final List<ReplyDto> reply_list = repository.searchByAllBoard(board).stream().map(ReplyDto::new).collect(Collectors.toList());
        // target 이 되는 stream 리스트를 만듭니다. ex) [ 1L, 3L, 99L ]
        final List<Long> target_list = reply_list.stream().filter(x -> x.getTarget_reply_id() == -1L)
                .map(ReplyDto::getId).collect(Collectors.toList());
        // 대댓글 id 에 매칭되는 리스트를 stream 상에 만들고 [ {id: [1L], re:[ 4L, 9L ]} ] 형태로 만듭니다.
        final List<HashMap<String, List<Long>>> test_list = target_list.stream()
                .map(x -> Maps.newHashMap(ImmutableMap.of("id", Collections.singletonList(x) , "re",
                        reply_list.stream().filter(y -> Objects.equals(y.getTarget_reply_id(), x)).map(ReplyDto::getId).collect(Collectors.toList())
                ))).collect(Collectors.toList());
        // test 를 replyDto로 새로 만듭니다.

        // return repository.searchByAllBoard(board).stream().map(ReplyDto::new).collect(Collectors.toList());
        return test_list.stream()
                .map(x -> new ReplyDto(
                        reply_list.stream().filter(y -> Objects.equals(y.getId(), x.get("id").get(0))).collect(Collectors.toList()).get(0),
                         x.get("re").stream().map(z ->
                                        reply_list.stream().filter(y -> Objects.equals(y.getId(), z)).collect(Collectors.toList()).get(0)
                                ).toList()
                )).collect(Collectors.toList());
    }
}
