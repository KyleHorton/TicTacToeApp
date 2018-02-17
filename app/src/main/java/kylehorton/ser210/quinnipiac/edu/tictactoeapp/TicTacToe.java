package kylehorton.ser210.quinnipiac.edu.tictactoeapp;

import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Kyleh on 2/12/2018.
 */

public class TicTacToe implements ITicTacToe {

    // The game board and the game status
    // variables to identify whose turn it is and the AI's move
    private static final int ROWS = 3, COLS = 3; // number of rows and columns
    private int[][] board = new int[ROWS][COLS]; // game board in 2D array
    private int currPlayer;
    private int aiMove;

    public TicTacToe(){

        currPlayer = 0;

    }

    @Override
    public void clearBoard() {


        board[0][0] = EMPTY;
        board[0][1] = EMPTY;
        board[0][2] = EMPTY;
        board[1][0] = EMPTY;
        board[1][1] = EMPTY;
        board[1][2] = EMPTY;
        board[2][0] = EMPTY;
        board[2][1] = EMPTY;
        board[2][2] = EMPTY;

    }

    @Override
    public void setMove(int player, int location) {


        if (player == 0) {
            if (location == 0) {

                if (board[0][0] == EMPTY) {
                    board[0][0] = CROSS;
                }

            }
            if (location == 1) {

                if (board[0][1] == EMPTY) {
                    board[0][1] = CROSS;
                }

            }
            if (location == 2) {

                if (board[0][2] == EMPTY) {
                    board[0][2] = CROSS;
                }

            }
            if (location == 3) {

                if (board[1][0] == EMPTY) {
                    board[1][0] = CROSS;
                }

            }
            if (location == 4) {

                if (board[1][1] == EMPTY) {
                    board[1][1] = CROSS;
                }

            }
            if (location == 5) {

                if (board[1][2] == EMPTY) {
                    board[1][2] = CROSS;
                }

            }
            if (location == 6) {

                if (board[2][0] == EMPTY) {
                    board[2][0] = CROSS;
                }

            }
            if (location == 7) {

                if (board[2][1] == EMPTY) {
                    board[2][1] = CROSS;
                }

            }
            if (location == 8) {

                if (board[2][2] == EMPTY) {
                    board[2][2] = CROSS;
                }

            }

        } else if (player == 1) {

            if (location == 0) {

                board[0][0] = NOUGHT;


            }
            if (location == 1) {

                board[0][1] = NOUGHT;

            }
            if (location == 2) {

                board[0][2] = NOUGHT;

            }
            if (location == 3) {

                board[1][0] = NOUGHT;

            }
            if (location == 4) {

                board[1][1] = NOUGHT;
            }
            if (location == 5) {

                board[1][2] = NOUGHT;

            }
            if (location == 6) {

                board[2][0] = NOUGHT;

            }
            if (location == 7) {

                board[2][1] = NOUGHT;

            }
            if (location == 8) {

                board[2][2] = NOUGHT;

            }

        }

    }

    @Override
    public int getComputerMove() {
        // number randomly generated
        aiMove = (int) (Math.random() * 9);

        // checks if spot is empty
        while (board[aiMove / 3][aiMove % 3] != EMPTY) {

            // if it isn't empty, generates a new number
            aiMove = (int) (Math.random() * 9);
        }

        return aiMove;
    }

    @Override
    public int checkForWinner() {

        // checks all possibilities of human winning
        if ((board[0][0] == CROSS && board[0][1] == CROSS && board[0][2] == CROSS)
                || (board[0][0] == CROSS && board[1][0] == CROSS && board[2][0] == CROSS)
                || (board[1][0] == CROSS && board[1][1] == CROSS && board[1][2] == CROSS)
                || (board[2][0] == CROSS && board[2][1] == CROSS && board[2][2] == CROSS)
                || (board[0][1] == CROSS && board[1][1] == CROSS && board[2][1] == CROSS)
                || (board[0][2] == CROSS && board[1][2] == CROSS && board[2][2] == CROSS)
                || (board[0][0] == CROSS && board[1][1] == CROSS && board[2][2] == CROSS)
                || (board[0][2] == CROSS && board[1][1] == CROSS && board[2][0] == CROSS)) {
            return 2;
        }

        // checks all possibilities of AI winning
        if ((board[0][0] == NOUGHT && board[0][1] == NOUGHT && board[0][2] == NOUGHT)
                || (board[0][0] == NOUGHT && board[1][0] == NOUGHT && board[2][0] == NOUGHT)
                || (board[1][0] == NOUGHT && board[1][1] == NOUGHT && board[1][2] == NOUGHT)
                || (board[2][0] == NOUGHT && board[2][1] == NOUGHT && board[2][2] == NOUGHT)
                || (board[0][1] == NOUGHT && board[1][1] == NOUGHT && board[2][1] == NOUGHT)
                || (board[0][2] == NOUGHT && board[1][2] == NOUGHT && board[2][2] == NOUGHT)
                || (board[0][0] == NOUGHT && board[1][1] == NOUGHT && board[2][2] == NOUGHT)
                || (board[0][2] == NOUGHT && board[1][1] == NOUGHT && board[2][0] == NOUGHT)) {
            return 3;

        } else if (board[0][0] != EMPTY && board[0][1] != EMPTY && board[0][2] != EMPTY
                && board[1][0] != EMPTY && board[2][0] != EMPTY && board[1][1] != EMPTY
                && board[1][2] != EMPTY && board[2][1] != EMPTY && board[2][2] != EMPTY){
            return 1;

        }

        // if none of the possibilities above are met, must still be playing
        return 0;
    }
}
