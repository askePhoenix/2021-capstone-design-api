package com.capstone.kmcapstone.board.model;

import com.capstone.kmcapstone.user.model.UserInfo;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "board_page")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class BoardPageInfo {
    @Id
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "writer")
    @ManyToOne
    private UserInfo writer;


}
