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
 * The multiplayer java class. This class allows two players to play against each other.
 */
public class MultiplayerActivity extends Activity {

    // variables
    public static final String EXTRA_MESSAGE = "message";
    private Button b0, b1, b2, b3, b4, b5, b6, b7, b8, reset;
    private TextView playerTurn;
    private int winner;
    private int moves;
    private boolean playing;
    private TicTacToe TTTBoard = new TicTacToe();
    private boolean player1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); //create the activity
        setContentView(R.layout.activity_multiplayer);
        Intent intent = getIntent();
        String userName = intent.getStringExtra(EXTRA_MESSAGE); //display the user's name
        TextView user = (TextView) findViewById(R.id.user);
        user.setText("Good luck!");

        moves = 0; // number of moves made by human
        playing = true; //state of game
        winner = 0; // who wins
        player1 = true; // keeps track of who's turn it is

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
        playerTurn.setText("It's Player 1's turn!");

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
        player1 = true;
        playerTurn.setText("It's Player 1's turn!");
        moves = 0;
        reset.setVisibility(View.INVISIBLE);
    }

    /**
     * Method used to perform an action when a button is clicked
     * Since the conditionals all work the same, refer to first statement's comments
     */
    public void onClickMove(View view) {
        if (playing) {// used to allow the buttons to perform an action when the game is playing
            if (view.getId() == b0.getId()) { //check to see which button is clicked
                if (player1){ // if its player 1's turn do...
                    b0.setBackgroundResource(R.mipmap.x); // sets background on button
                    TTTBoard.setMove(0, 0); // sets move in TTT array
                    playerTurn.setText("It's Player 2's turn!"); //displays the next player's turn
                    checkForWinnerUI(); // checks to see who won (if there's a winner)
                    player1 = false; // makes it player 2's turn
                } else { // if it isn't player 1's turn
                    b0.setBackgroundResource(R.mipmap.o); // set background on button
                    TTTBoard.setMove(1, 0); // sets move in TTT array
                    playerTurn.setText("It's Player 1's turn!"); // displays the next player's turn
                    checkForWinnerUI(); // checks to see if there's a winner
                    player1 = true; // makes it player 1's turn
                }
            }
            if (view.getId() == b1.getId()){
                if (player1){
                    b1.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 1);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b1.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 1);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b2.getId()){
                if (player1){
                    b2.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 2);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b2.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 2);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b3.getId()){
                if (player1){
                    b3.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 3);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b3.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 3);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b4.getId()){
                if (player1){
                    b4.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 4);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b4.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 4);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b5.getId()){
                if (player1){
                    b5.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 5);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b5.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 5);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b6.getId()){
                if (player1){
                    b6.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 6);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b6.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 6);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b7.getId()){
                if (player1){
                    b7.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 7);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b7.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 7);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
                }
            }
            if (view.getId() == b8.getId()){
                if (player1){
                    b8.setBackgroundResource(R.mipmap.x);
                    TTTBoard.setMove(0, 8);
                    playerTurn.setText("It's Player 2's turn!");
                    checkForWinnerUI();
                    player1 = false;
                } else {
                    b8.setBackgroundResource(R.mipmap.o);
                    TTTBoard.setMove(1, 8);
                    playerTurn.setText("It's Player 1's turn!");
                    checkForWinnerUI();
                    player1 = true;
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
            playerTurn.setText("Player 1 won!");
            playing = false;
            reset.setVisibility(View.VISIBLE);
        }
        if (winner == 3) {
            playerTurn.setText("Player 2 won!");
            playing = false;
            reset.setVisibility(View.VISIBLE);

        } else if (winner == 0) {
            playing = true;
        }
    }

    /**
     *
     * Brings user back to splash screen
     */
    public void onClickGoBack(View view) {
        Intent intentBack = new Intent(this, MainActivity.class);
        startActivity(intentBack);
        finish();
    }
}

