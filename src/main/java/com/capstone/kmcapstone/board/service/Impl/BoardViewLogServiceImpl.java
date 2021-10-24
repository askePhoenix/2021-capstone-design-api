package com.capstone.kmcapstone.board.service.Impl;

import com.capstone.kmcapstone.board.model.BoardPageInfo;
import com.capstone.kmcapstone.board.model.BoardViewLogInfo;
import com.capstone.kmcapstone.board.repository.BoardDetailRepository;
import com.capstone.kmcapstone.board.repository.BoardViewLogRepository;
import com.capstone.kmcapstone.board.service.BoardViewLogService;
import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardViewLogServiceImpl implements BoardViewLogService {
    // 게시판 조회수 조회에 대한 서비스

    // 조회수 로그 Repository
    private final BoardViewLogRepository repository;
    private final BoardDetailRepository detailRepository;

    // 로그 작성
    @Override
    public void createLogs(Long target, UserInfo userInfo) {
        final BoardPageInfo pageInfo = detailRepository.findById(target).orElseGet(
                () -> BoardPageInfo.builder().id(-1L).build()
        );

        final BoardViewLogInfo info = repository.searchByTargetBoard(
                pageInfo, userInfo
        ).orElseGet(() -> BoardViewLogInfo.builder()
                .visitant(userInfo)
                .target_board(pageInfo)
                .build());

        repository.save(info);
    }

    // 로그 조회(카운트)
    @Override
    public Integer getLogsCount(Long target) {
        final BoardPageInfo pageInfo = detailRepository.findById(target).orElseGet(
                () -> BoardPageInfo.builder().id(-1L).build()
        );
        return pageInfo.getId() == -1L ? 0 : repository.CountAllByTargetBoard(pageInfo);
    }


}
