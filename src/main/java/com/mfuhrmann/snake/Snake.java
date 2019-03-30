package com.mfuhrmann.snake;

import com.mfuhrmann.snake.board.Point;
import com.mfuhrmann.snake.board.SnakeCell;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private final SnakeCell head;
    private final int size;
    private final List <SnakeCell> body = new ArrayList<>();

    public Snake(SnakeCell head, int size) {
        this.head = head;
        this.size = size;
    }

    public void moveUp() {
        Point point = head.getPoint();
        if (point.getY() == 0) {
            point = new Point(point.getX(), point.getY() + size);
        }
        head.setPoint(new Point(point.getX(), (point.getY() - 1)%size));
    }

    public void moveDown() {
        Point point = head.getPoint();
        head.setPoint(new Point(point.getX(),(point.getY()+1)%size));
    }

    public void moveLeft() {
        Point point = head.getPoint();
        if (point.getX() == 0) {
            point = new Point(point.getX()+size, point.getY());
        }
        head.setPoint(new Point((point.getX()-1)%size,point.getY()));
    }

    public void moveRight() {
        Point point = head.getPoint();
        head.setPoint(new Point((point.getX()+1)%size,point.getY()));
    }

    public SnakeCell getHead() {
        return head;
    }

    public void grow() {
        SnakeCell tail = getTail();

    }

    public SnakeCell getTail() {
        if (body.isEmpty()) {
            return head;
        } else {
            return body.get(body.size() - 1);
        }
    }
}
