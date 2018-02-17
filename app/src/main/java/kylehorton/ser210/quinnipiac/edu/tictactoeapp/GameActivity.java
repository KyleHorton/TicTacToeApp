package kylehorton.ser210.quinnipiac.edu.tictactoeapp;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static android.content.ContentValues.TAG;

/**
 * The main game java class.  This game is player vs computer.
 */
public class GameActivity extends Activity {

    // variables
    public static final String EXTRA_MESSAGE = "message";
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, reset;
    private TextView playerTurn;
    private int winner;
    private int moves;
    private boolean playing;
    private TicTacToe TTTBoard = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //create the activity
        setContentView(R.layout.activity_game);
        Intent intent = getIntent();
        String userName = intent.getStringExtra(EXTRA_MESSAGE); //display the user's name
        TextView user = (TextView) findViewById(R.id.user);
        user.setText("Good luck " + userName + "!"); // displays the user's name

        moves = 0; // number of moves made by human
        playing = true; //state of the game
        winner = 0; // who won

        // gives an ID to each button
        b0 = (Button) findViewById(R.id.Button0);
        b1 = (Button) findViewById(R.id.Button1);
        b2 = (Button) findViewById(R.id.Button2);
        b3 = (Button) findViewById(R.id.Button3);
        b4 = (Button) findViewById(R.id.Button4);
        b5 = (Button) findViewById(R.id.Button5);
        b6 = (Button) findViewById(R.id.Button6);
        b7 = (Button) findViewById(R.id.Button7);
        b8 = (Button) findViewById(R.id.Button8);
        reset = (Button) findViewById(R.id.resetButton);
        playerTurn = (TextView) findViewById(R.id.result);
        playerTurn.setText("It's your turn!");

        // if the game is destroyed, set data to these saved values
        if (savedInstanceState != null){
            moves = savedInstanceState.getInt("moves");
            playing = savedInstanceState.getBoolean("playing");
            winner = savedInstanceState.getInt("winner");
        }

    }

    /**
     * Used to save data values when game activity is destroyed on orientation change
     */
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("moves", moves);
        savedInstanceState.putBoolean("playing", playing);
        savedInstanceState.putInt("winner", winner);


    }

    /**
     * method that performs action when the reset button is clicked
     * sets the backgrounds of the buttons to the default
     * clears the array board in the TicTacToe class
     * sets text for player
     * resets widgets
     */
    public void onClickReset(View view) {
        b0.setBackgroundResource(android.R.drawable.btn_default);
        b1.setBackgroundResource(android.R.drawable.btn_default);
        b2.setBackgroundResource(android.R.drawable.btn_default);
        b3.setBackgroundResource(android.R.drawable.btn_default);
        b4.setBackgroundResource(android.R.drawable.btn_default);
        b5.setBackgroundResource(android.R.drawable.btn_default);
        b6.setBackgroundResource(android.R.drawable.btn_default);
        b7.setBackgroundResource(android.R.drawable.btn_default);
        b8.setBackgroundResource(android.R.drawable.btn_default);
        TTTBoard.clearBoard();
        winner = 0;
        playing = true;
        playerTurn.setText("It's your turn!");
        moves = 0;
        reset.setVisibility(View.INVISIBLE);
    }

    /**
     * Method used to perform an action when a button is clicked
     * Since the conditionals all work the same, refer to first statement's comments
     */
    public void onClickMove(View view) {
        if (playing) { // used to allow the buttons to perform an action when the game is playing
            if (view.getId() == b0.getId()) { // checks the buttons id
                TTTBoard.setMove(0, 0); // sets the position in the array board
                b0.setBackgroundResource(R.mipmap.x); // sets the position in the UI board
                checkForWinnerUI(); // check state of game
                moves++; // increments the number of turns made by the human
                if (moves < 5 && playing) { // if there's a spot left on the board for the AI, make that move
                    computerMove(); // place the computer move
                }
            }
            if (view.getId() == b1.getId()) {
                TTTBoard.setMove(0, 1);
                b1.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b2.getId()) {
                TTTBoard.setMove(0, 2);
                b2.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b3.getId()) {
                TTTBoard.setMove(0, 3);
                b3.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b4.getId()) {
                TTTBoard.setMove(0, 4);
                b4.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b5.getId()) {
                TTTBoard.setMove(0, 5);
                b5.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b6.getId()) {
                TTTBoard.setMove(0, 6);
                b6.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b7.getId()) {
                TTTBoard.setMove(0, 7);
                b7.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
            if (view.getId() == b8.getId()) {
                TTTBoard.setMove(0, 8);
                b8.setBackgroundResource(R.mipmap.x);
                checkForWinnerUI();
                moves++;
                if (moves < 5 && playing) {
                    computerMove();
                }
            }
        }
    }

    /**
     * Method created to check the state of the game and perform actions based on it
     */
    public void checkForWinnerUI() {
        winner = TTTBoard.checkForWinner();
        if (winner == 1) {
            playerTurn.setText("It's a tie!");
            playing = false;
            reset.setVisibility(View.VISIBLE);
        }

        if (winner == 2) {
            playerTurn.setText("You won!");
            playing = false;
            reset.setVisibility(View.VISIBLE);
        }
        if (winner == 3) {
            playerTurn.setText("You lost!");
            playing = false;
            reset.setVisibility(View.VISIBLE);

        } else if (winner == 0) {
            playing = true;
        }
    }

    /**
     * Method that displays the computer player's move on the UI board
     * It also delays the move and displays the text that says whose turn it is
     */
    public void computerMove() {

        final int move = TTTBoard.getComputerMove();
        TTTBoard.setMove(1, move);
        playerTurn.setText("Computer is making a move...");

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {

            @Override
            public void run() {

                if (move == 0) {
                    b0.setBackgroundResource(R.mipmap.o);

                } else if (move == 1) {
                    b1.setBackgroundResource(R.mipmap.o);
                } else if (move == 2) {
                    b2.setBackgroundResource(R.mipmap.o);
                } else if (move == 3) {
                    b3.setBackgroundResource(R.mipmap.o);
                } else if (move == 4) {
                    b4.setBackgroundResource(R.mipmap.o);
                } else if (move == 5) {
                    b5.setBackgroundResource(R.mipmap.o);
                } else if (move == 6) {
                    b6.setBackgroundResource(R.mipmap.o);
                } else if (move == 7) {
                    b7.setBackgroundResource(R.mipmap.o);
                } else if (move == 8) {
                    b8.setBackgroundResource(R.mipmap.o);
                }
                playerTurn.setText("It's your turn!");
                checkForWinnerUI();
            }

        }, 2000);

    }

    /**
     *
     * Returns user back to splash screen
     */
    public void onClickGoBack(View view) {
        Intent intentBack = new Intent(this, MainActivity.class);
        startActivity(intentBack);
        finish();
    }
}
