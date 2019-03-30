package com.mfuhrmann.snake.board;

public class SnakeCell extends BoardCell {
    private static final char displayChar = '@';
    public SnakeCell(Point point) {
        super(point, displayChar);

    }

}
