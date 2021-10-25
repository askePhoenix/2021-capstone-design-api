package com.capstone.kmcapstone.board.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RecommendDto {
    private int count;

    public RecommendDto(int count) {
        this.count = count;
    }
}
