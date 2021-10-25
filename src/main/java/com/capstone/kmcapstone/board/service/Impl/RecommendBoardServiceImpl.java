package com.capstone.kmcapstone.board.service.Impl;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.model.RecommendBoardInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.board.repository.RecommendBoardRepository;
import com.capstone.kmcapstone.board.service.RecommendBoardService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecommendBoardServiceImpl implements RecommendBoardService {
    private final RecommendBoardRepository repository;
    private final BoardDetailRepository boardDetailRepository;

    // 게시글 추천하기
    @Override
    public Integer giveRecommend(Long target, UserInfo userInfo) {
        try {
            BoardPageInfo boardPageInfo = boardDetailRepository.searchById(target).orElseThrow(
                    NullPointerException::new
            );
            final RecommendBoardInfo duple = repository.searchTargetAndUser(boardPageInfo, userInfo).orElseGet(
                    () -> RecommendBoardInfo.builder()
                            .id(-1L)
                            .build() );
            repository.save(
                    RecommendBoardInfo.builder()
                            .id( duple.getId() == -1L ? null : duple.getId() )
                            .give_user(userInfo)
                            .target_board(boardPageInfo)
                            .createDateTime(duple.getId() == -1L ? null : duple.getCreateDateTime())
                            .build()
            );
            return repository.CountAllTargetBoard(boardPageInfo);
        } catch (NullPointerException e) {
            return 0;
        }
    }

    // 게시글 추천 수 가져오기
    @Override
    public Integer loadRecommend(Long target) {
        try {
            BoardPageInfo boardPageInfo = boardDetailRepository.searchById(target).orElseThrow(
                    NullPointerException::new
            );
            return repository.CountAllTargetBoard(boardPageInfo);
        } catch (NullPointerException e) {
            return 0;
        }
    }

}
