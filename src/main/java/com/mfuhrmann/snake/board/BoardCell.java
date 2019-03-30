package com.mfuhrmann.snake.board;

public abstract class BoardCell {

    private Point point;
    private final char displayChar;

    public BoardCell(Point point, char displayChar) {
        this.point = point;
        this.displayChar = displayChar;
    }

    @Override
    public String toString() {
        return String.valueOf(displayChar);
    }

    public char getDisplayChar() {
        return displayChar;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
