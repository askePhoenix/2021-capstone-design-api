package com.capstone.kmcapstone.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class BoardViewsDto {
    private int count;

    public BoardViewsDto(int count) {
        this.count = count;
    }
}
