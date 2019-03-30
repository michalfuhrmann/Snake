package com.mfuhrmann.snake;

import com.mfuhrmann.snake.board.Board;

import java.util.Scanner;

public class Game {

    public Game(int size) {
        Board board = new Board(size);
        board.print();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String nextCommand = scanner.next();
            switch (nextCommand) {
                case "w":
                    board.keyUp();
                    break;
                case "s":
                    board.keyDown();
                    break;
                case "a":
                    board.keyLeft();
                    break;
                case "d":
                    board.keyRight();
                    break;
                default:
                    System.out.println("Wrong input.: " + nextCommand);
            }
            board.print();
        }
    }

    public static void main(String[] args) {

        Game game = new Game(9);

    }
}
