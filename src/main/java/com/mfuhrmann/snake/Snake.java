package com.mfuhrmann.snake;

import com.mfuhrmann.snake.board.Point;
import com.mfuhrmann.snake.board.SnakeCell;

import java.util.ArrayList;
import java.util.List;

public class Snake {
    private boolean growing = false;
    private final SnakeCell head;
    private final int size;
    private final List<SnakeCell> body = new ArrayList<>();

    public Snake(SnakeCell head, int size) {
        this.head = head;
        this.size = size;
    }

    public void moveUp() {
        Point oldHead = head.getPoint();

        if (oldHead.getY() == 0) {
            oldHead = new Point(oldHead.getX(), oldHead.getY() + size);
        }
        head.setPoint(new Point(oldHead.getX(), (oldHead.getY() - 1) % size));

        if (growing) {
            appendBody(oldHead);
        }
        if (!growing) {
            moveBody(oldHead);
        }

    }


    public void moveDown() {
        Point oldHead = head.getPoint();
        head.setPoint(new Point(oldHead.getX(), (oldHead.getY() + 1) % size));


        if (growing) {
            appendBody(oldHead);
        }
        if (!growing) {
            moveBody(oldHead);
        }

    }

    public void moveLeft() {
        Point oldHead = head.getPoint();
        if (oldHead.getX() == 0) {
            oldHead = new Point(oldHead.getX() + size, oldHead.getY());
        }
        head.setPoint(new Point((oldHead.getX() - 1) % size, oldHead.getY()));

        if (growing) {
            appendBody(oldHead);
        }
        if (!growing) {
            moveBody(oldHead);
        }
    }

    public void moveRight() {
        Point oldHead = head.getPoint();
        head.setPoint(new Point((oldHead.getX() + 1) % size, oldHead.getY()));

        if (growing) {
            appendBody(oldHead);
        }
        if (!growing) {
            moveBody(oldHead);
        }

    }

    public SnakeCell getHead() {
        return head;
    }

    public void grow() {
        growing = true;
        SnakeCell tail = getTail();


    }

    public SnakeCell getTail() {
        if (body.isEmpty()) {
            return head;
        } else {
            return body.get(body.size() - 1);
        }
    }


    private void moveBody(Point oldHead) {
        if (body.isEmpty()) {
            return;
        }

        for (int i = body.size(); i > 0; i--) {
            Point previousBodyPoint = body.get(i + 1).getPoint();
            body.get(i).setPoint(previousBodyPoint);

        }
        SnakeCell firstBody = body.get(0);
        firstBody.setPoint(oldHead);

    }


    private void appendBody(Point oldHead) {

        body.add(new SnakeCell(oldHead));

    }
}
