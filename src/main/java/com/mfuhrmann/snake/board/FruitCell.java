package com.mfuhrmann.snake.board;

public class FruitCell extends BoardCell {
    private static final char displayChar = '*';
    public FruitCell(Point point) {
        super(point, displayChar);
    }
}
