package com.capstone.kmcapstone.board.service;

import com.capstone.kmcapstone.user.model.UserInfo;

public interface BoardViewLogService {
    // 로그 작성
    void createLogs(Long target, UserInfo userInfo);

    // 로그 조회(카운트)
    Integer getLogsCount(Long target);
}
