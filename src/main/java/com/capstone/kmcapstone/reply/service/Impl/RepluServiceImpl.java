package com.capstone.kmcapstone.reply.service.Impl;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.reply.dto.ReplyDto;
import com.capstone.kmcapstone.reply.dto.ReplyVIewDto;
import com.capstone.kmcapstone.reply.model.ReplyInfo;
import com.capstone.kmcapstone.reply.repository.ReplyRepository;
import com.capstone.kmcapstone.reply.service.ReplyService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
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
                            .target_reply(vIewDto.isAction() ?
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
    public List<ReplyDto> getReplys(Long target_board){
        BoardPageInfo board = boardDetailRepository.searchById(target_board).orElseGet(
                () -> BoardPageInfo.builder().id(-1L).build()
        );
        return repository.searchByAllBoard(board).stream().map(ReplyDto::new).collect(Collectors.toList());
    }
}
