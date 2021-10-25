package com.capstone.kmcapstone.board.service;

import com.capstone.kmcapstone.user.model.UserInfo;

public interface RecommendBoardService {
    // 게시글 추천하기
    Integer giveRecommend(Long target, UserInfo userInfo);

    // 게시글 추천 수 가져오기
    Integer loadRecommend(Long target);
}
