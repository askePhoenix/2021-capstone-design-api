package com.capstone.kmcapstone.board.dto;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
public class BoardPageDto {
    private Long id;

    private UserInfo writer;
    private String title;

    private String contents;

    private boolean isDeleted;
}
