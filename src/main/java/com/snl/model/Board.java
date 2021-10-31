package com.snl.model;

import lombok.Getter;
import lombok.Setter;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Board {
    private int boardSize;
    private List<Snake> snakes;
    private List<Ladder> ladders;

    public Board(
            final int boardSize) {
        this.boardSize = boardSize;
        this.snakes = new ArrayList<>();
        this.ladders = new ArrayList<>();
    }

}
