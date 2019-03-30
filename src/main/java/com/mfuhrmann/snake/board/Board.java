package com.mfuhrmann.snake.board;

import com.mfuhrmann.snake.Direction;
import com.mfuhrmann.snake.Snake;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Board {
    private final int size;

    private final BoardCell[][] boardCells;
    private Snake snake;

    public Board(int size) {
        if (size <= 2) {
            throw new IllegalArgumentException("Board size is too small");
        }
        this.size = size;
        boardCells = new BoardCell[size][size];
        generateRandomBoard();

    }

    private void generateRandomBoard() {
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                boardCells[y][x] = new EmptyCell(new Point(x, y));

            }
        }
        generateFruitPosition();
        SnakeCell snakeHead = generateSnakeHead();
        this.snake = new Snake(snakeHead, size);
    }

    private SnakeCell generateSnakeHead() {
        int snakeStartPositionX = size/2;
        int snakeStartPositionY = size/2;
        SnakeCell snakeCell = new SnakeCell(new Point(snakeStartPositionX, snakeStartPositionY));
        boardCells[snakeStartPositionY][snakeStartPositionX] = snakeCell;
        return snakeCell;
    }

    private void generateFruitPosition() {
        int fruitRandomX = (int) (Math.random() * (size - 1));
        int fruitRandomY = (int) (Math.random() * (size - 1));
        FruitCell fruitCell = new FruitCell(new Point(fruitRandomX, fruitRandomY));
        boardCells[fruitRandomY][fruitRandomX] = fruitCell;
    }


    public void print() {
        IntStream.range(0, size + 2).forEach(value -> System.out.print("X "));
        System.out.println();
        for (BoardCell[] cellRow : boardCells) {
            System.out.print("X ");
            Arrays.stream(cellRow).forEach(boardCell -> System.out.print(boardCell.getDisplayChar() + " "));
            System.out.print('X');
            System.out.println();

        }
        IntStream.range(0, size + 2).forEach(value -> System.out.print("X "));
    }

    public void performGameLoop() {

    }

    public void keyUp() {
        keyPressed(Direction.UP);
    }

    public void keyDown() {
        keyPressed(Direction.DOWN);
    }

    public void keyLeft() {
        keyPressed(Direction.LEFT);
    }

    public void keyRight() {
        keyPressed(Direction.RIGHT);

    }

    private void keyPressed(Direction direction) {
        SnakeCell head = snake.getHead();
        Point oldHead = head.getPoint();
        boardCells[oldHead.getY()][oldHead.getX()] = new EmptyCell(oldHead);
        checkCollision();
        performAction(direction);
        Point newHead = head.getPoint();
        boardCells[newHead.getY()][newHead.getX()] = snake.getHead();
    }

    private void performAction(Direction direction) {
        switch (direction) {

            case UP:
                snake.moveUp();
                break;
            case DOWN:
                snake.moveDown();
                break;
            case LEFT:
                snake.moveLeft();
                break;
            case RIGHT:
                snake.moveRight();
                break;
        }
    }

    private void checkCollision() {
        BoardCell checkCell = boardCells[snake.getHead().getPoint().getY()][snake.getHead().getPoint().getX()];
        if (checkCell instanceof FruitCell) {
            snake.grow();
        }
    }

}
