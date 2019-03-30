package com.mfuhrmann.snake.board;

public class EmptyCell extends BoardCell {
    private static final char displayChar = ' ';
    public EmptyCell(Point point) {
        super(point, displayChar);
    }
}
