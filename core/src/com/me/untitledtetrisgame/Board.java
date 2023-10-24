package com.me.untitledtetrisgame;

import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.CharArray;

import java.util.Arrays;

public class Board {

    private final int width = 10;
    private final int height = 20;

    Array<CharArray> board = new Array<>();

    CharArray tmp = new CharArray();

    public Board () {


        for (int j = 0; j < width + 2; j++) {
            tmp.add('#');
        }


        for (int i = 0; i < height + 5; i++) {
            board.add(new CharArray());
        }

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < width + 2; j++) {
                board.get(i).add('#');
            }
        }

        for (int i = 4; i < height + 4; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (j == 0 || j == width + 1) {
                    board.get(i).add('#');
                } else {
                    board.get(i).add('.');
                }
            }
        }

        for (int j = 0; j < width + 2; j++) {
            board.get(height + 4).add('#');
        }

    }

    public void update () {


        for (int j = 0; j < width + 2; j++) {
            tmp.set(j, board.get(0).get(j));
        }

        for (int r = height + 3; r > 0; r--) {
            board.set(r, board.get(r - 1));
            System.out.print("  R: " + r);
        }

        for (int c = 1; c < width + 1; c++) {
                board.get(4).set(c, '.');
        }

        for (int j = 0; j < width + 2; j++) {
            board.get(0).set(j, '#');
        }

//        for (int j = 0; j < width + 2; j++) {
//            board.get(0).set(0, tmp.get(j));
//        }
    }

    public void addTetromino(char tetromino) {

        if (canAddTetromino()) {
            switch (tetromino) {
                case 'I':
                    board.get(0).set(5, 'I');
                    board.get(1).set(5, 'I');
                    board.get(2).set(5, 'I');
                    board.get(3).set(5, 'I');
                    System.out.println("I");
                    break;
                case 'O':
                    board.get(2).set(5, 'O');
                    board.get(2).set(6, 'O');
                    board.get(3).set(5, 'O');
                    board.get(3).set(6, 'O');
                    System.out.println("O");
                    break;
                case 'T':
                    board.get(2).set(4, 'T');
                    board.get(2).set(5, 'T');
                    board.get(2).set(6, 'T');
                    board.get(3).set(5, 'T');
                    System.out.println("T");
                    break;
                case 'J':
                    board.get(1).set(5, 'J');
                    board.get(2).set(5, 'J');
                    board.get(3).set(5, 'J');
                    board.get(3).set(4, 'J');
                    System.out.println("J");
                    break;
                case 'L':
                    board.get(1).set(5, 'L');
                    board.get(2).set(5, 'L');
                    board.get(3).set(6, 'L');
                    board.get(3).set(5, 'L');
                    System.out.println("L");
                    break;
                case 'S':
                    board.get(2).set(5, 'S');
                    board.get(2).set(6, 'S');
                    board.get(3).set(4, 'S');
                    board.get(3).set(5, 'S');
                    System.out.println("S");
                    break;
                case 'Z':
                    board.get(2).set(4, 'Z');
                    board.get(2).set(5, 'Z');
                    board.get(3).set(5, 'Z');
                    board.get(3).set(6, 'Z');
                    System.out.println("Z");
                    break;
                default:
                    System.out.println("ERROR: Invalid Tetromino");
            }
        } else {
            System.out.println("ERROR: No space to add Tetromino");
        }

    }

    private boolean canAddTetromino () {

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < width + 2; j++) {
                if (board.get(i).get(j) != '#') {
                    return false;
                }
            }
        }
        return true;
    }

    public void printBoard () {

        int count_rows = 0;
        for (CharArray i : board.iterator()) {
            count_rows++;
            int count_cols = 0;
            for (int j = 0; j < i.size; j++) {
                System.out.print(i.get(j));
                count_cols++;
            }
            System.out.println("   COLS: " + count_cols + "   ROW: " + count_rows);
        }
        System.out.println("\nTOTAL ROWS: " + count_rows);
    }
}
