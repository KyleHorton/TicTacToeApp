package kylehorton.ser210.quinnipiac.edu.tictactoeapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

/**
 * The splash screen java class. The app begins here.
 */
public class MainActivity extends Activity {
    private String name = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     *
     * Brings user to the main game. Player vs AI
     */
    public void onClickPlay(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Please enter your name!");
        final EditText input = new EditText(this);
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        alert.setView(input);
        alert.setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                name = input.getText().toString();
                Intent intent = new Intent(MainActivity.this, GameActivity.class);
                intent.putExtra(GameActivity.EXTRA_MESSAGE,name);
                startActivity(intent);
                finish();
            }
        });
        alert.setNegativeButton("Go Back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alert.show();

    }

    // provides user with a dialog that tells them the instructions
    public void onClickInstructions(View view) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("How to play");
        alert.setMessage("If you click Play: It's you vs the computer! Select the square that you want to occupy each turn. Occupy three squares " +
                "in a row (in any direction) and you win! BUT, if the computer gets three in a row you lose! If neither of you succeed in " +
                "getting three in a row the game ends in a tie! " +
                "\n If you click Multiplayer: It's you vs a friend...or a foe! Take turns choosing spots and see who wins!");
        alert.setNeutralButton("Got it!", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        alert.show();
    }

    /**
     * Brings user to multiplayer screen
     */
    public void onClickMulti(View view) {
        Intent intent = new Intent(this, MultiplayerActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * Exits game
     */
    public void onClickLeave(View view) {
        finish();
        System.exit(0);
    }


}
