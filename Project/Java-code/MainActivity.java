package com.example.pateldhirspeedywords;

/*
Name: Dhir Patel
Purpose: To create a board game Speedy Word
Date: June 15, 2020
 */

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Global variables
    //PictureStack and LetterStack are the two card decks for the two objects
    PictureStack p = new PictureStack();
    LetterStack l = new LetterStack();
    //The card object which holds the categories is made global as it is implemented in different methods
    Picture a;
    //Global variables to keep track of the score for the 4 players
    int score1 = 0;
    int score2 = 0;
    int score3 = 0;
    int score4 = 0;
    //These two variables are for the background music in the game
    MediaPlayer music;
    int paused;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Finds the music file in the directory
        music = MediaPlayer.create(MainActivity.this, R.raw.bckgmusic);
        //Starts the music
        music.start();
        //Keeps on looping the music so it doesn't end while the game is still active
        music.setLooping(true);
    }

    //Display method handles the changing of the cards on the screen
    //This method is responsible for popping of the top card for from the two card decks
    public void display() {
        //while the deck is not empty
        if (!p.isEmpty()) {
            //pop a card off of the category card deck
            a = p.pop();
            //pop a card off of the letter card deck
            Letter b = l.pop();
            //set the corresponding image for the two decks
            ImageView i = (ImageView) findViewById(R.id.cardOne);
            a.setPic(i);
            ImageView j = (ImageView) findViewById(R.id.cardTwo);
            b.setPic(j);
        }
    }

    //This method provides the players with a hint
    //when the hint button is pressed on the screen, a message displaying the category and the letter of correspondence shows up
    public void hint(View view) {
        TextView CategoryHint = (TextView) findViewById(R.id.category);
        CategoryHint.setText(a.getCategory());
    }

    //This method correspondes to the "Next Card" button on the screen
    //When the button is pressed, this method is implemented and pops a card off the deck
    public void pop(View view) {
        //display() method called (This method does the popping of cards)
        display();
        //Resets the message each time the button is pressed
        TextView CategoryHint = (TextView) findViewById(R.id.category);
        CategoryHint.setText("Which Category & Letter?");
        //Checks if the deck is empty. If the deck is empty then it checks all the scores and presents a win message
        if (p.isEmpty()) {
            //If score1 is the the highest then player 1 wins
            if (score1 > score2 && score1 > score3 && score1 > score4)
                p1Win();
                //If score2 is the highest then player 2 wins
            else if (score2 > score1 && score2 > score3 && score2 > score4)
                p2Win();
                //If score3 is the highest then player 3 wins
            else if (score3 > score1 && score3 > score2 && score3 > score4)
                p3Win();
                //If score4 is the highest then player 4 wins
            else if (score4 > score1 && score4 > score2 && score4 > score3)
                p4Win();
                //If all the scores are equal then it's a tie
            else if (score1 == score2 && score1 == score3 && score1 == score4)
                Tie();
        }
    }

    //Keeps track of player 1's score
    public void player1(View view) {
        score1++;
        Button p1 = (Button) findViewById(R.id.one);
        p1.setText("Player 1: " + score1);
        Toast.makeText(getApplicationContext(), "Player 1 got a point!", Toast.LENGTH_SHORT).show();
    }

    //Keeps track of player 2's score
    public void player2(View view) {
        score2++;
        Button p2 = (Button) findViewById(R.id.two);
        p2.setText("Player 2: " + score2);
        Toast.makeText(getApplicationContext(), "Player 2 got a point!", Toast.LENGTH_SHORT).show();
    }

    //Keeps track of player 3's score
    public void player3(View view) {
        score3++;
        Button p3 = (Button) findViewById(R.id.three);
        p3.setText("Player 3: " + score3);
        Toast.makeText(getApplicationContext(), "Player 3 got a point!", Toast.LENGTH_SHORT).show();
    }

    //Keeps track of player 4's score
    public void player4(View view) {
        score4++;
        Button p4 = (Button) findViewById(R.id.four);
        p4.setText("Player 4: " + score4);
        Toast.makeText(getApplicationContext(), "Player 4 got a point!", Toast.LENGTH_SHORT).show();
    }

    //This method is implemented when the "reset" button is pressed on the screen
    //It resets the game and also shuffles the deck
    public void reset(View view) {
        //Shuffles both decks
        p.shuffle();
        l.shuffle();
        //Sets the top image of the two decks to a default image
        ImageView i = (ImageView) findViewById(R.id.cardOne);
        i.setImageResource(R.drawable.back);
        ImageView j = (ImageView) findViewById(R.id.cardTwo);
        j.setImageResource(R.drawable.categories);
        //Resets the message of the category
        TextView CategoryHint = (TextView) findViewById(R.id.category);
        CategoryHint.setText("Which Category & Letter?");
        //Resets the score to 0 for all four players
        score1 = 0;
        Button p1 = (Button) findViewById(R.id.one);
        p1.setText("Player 1: " + score1);
        score2 = 0;
        Button p2 = (Button) findViewById(R.id.two);
        p2.setText("Player 2: " + score2);
        score3 = 0;
        Button p3 = (Button) findViewById(R.id.three);
        p3.setText("Player 3: " + score1);
        score4 = 0;
        Button p4 = (Button) findViewById(R.id.four);
        p4.setText("Player 4: " + score2);
    }

    //A copy of the reset method
    //This method is created so that it can be used as a function in other methods of the program
    public void reset2() {
        //Shuffles both decks
        p.shuffle();
        l.shuffle();
        //Sets the top image of the two decks to a default image
        ImageView i = (ImageView) findViewById(R.id.cardOne);
        i.setImageResource(R.drawable.back);
        ImageView j = (ImageView) findViewById(R.id.cardTwo);
        j.setImageResource(R.drawable.categories);
        //Resets the message of the category
        TextView CategoryHint = (TextView) findViewById(R.id.category);
        CategoryHint.setText("Which Category & Letter?");
        //Resets the score to 0 for all four players
        score1 = 0;
        Button p1 = (Button) findViewById(R.id.one);
        p1.setText("Player 1: " + score1);
        score2 = 0;
        Button p2 = (Button) findViewById(R.id.two);
        p2.setText("Player 2: " + score2);
        score3 = 0;
        Button p3 = (Button) findViewById(R.id.three);
        p3.setText("Player 3: " + score1);
        score4 = 0;
        Button p4 = (Button) findViewById(R.id.four);
        p4.setText("Player 4: " + score2);
    }

    //Changes the screen to the instruction screen
    public void toinstructions(View view) {
        Intent i = new Intent(this, Instructions.class);
        startActivity(i);
    }

    //If player 1 wins then this method is called in the pop() method
    //This method creates a pop-up dialog box
    public void p1Win() {
        new AlertDialog.Builder(this)
                //The title on the Dialog
                .setTitle("Winner")
                //The message that will appear
                .setMessage("Congratulations!" +
                        "\nPlayer 1 wins the game!\n\nClick \"Ok'\' to reset the game.")
                //What to do if the button is pressed
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //If the button is clicked then a rating bar pops up prior to resetting the game
                        ShowRatingBar();
                        //If the button is clicked then the reset method is called
                        reset2();
                    }
                }).show();
    }

    //If player 2 wins then this method is called in the pop() method
    //This method creates a pop-up dialog box
    public void p2Win() {
        new AlertDialog.Builder(this)
                //The title on the Dialog
                .setTitle("Winner")
                //The message that will appear
                .setMessage("Congratulations!" +
                        "\nPlayer 2 wins the game!\n\nClick \"Ok'\' to reset the game.")
                //What to do if the button is pressed
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //If the button is clicked then a rating bar pops up prior to resetting the game
                        ShowRatingBar();
                        //If the button is clicked then the reset method is called
                        reset2();
                    }
                }).show();
    }

    //If player 3 wins then this method is called in the pop() method
    //This method creates a pop-up dialog box
    public void p3Win() {
        new AlertDialog.Builder(this)
                //The title on the Dialog
                .setTitle("Winner")
                //The message that will appear
                .setMessage("Congratulations!" +
                        "\nPlayer 3 wins the game!\n\nClick \"Ok'\' to reset the game.")
                //What to do if the button is pressed
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //If the button is clicked then a rating bar pops up prior to resetting the game
                        ShowRatingBar();
                        //If the button is clicked then the reset method is called
                        reset2();
                    }
                }).show();
    }

    //If player 4 wins then this method is called in the pop() method
    //This method creates a pop-up dialog box
    public void p4Win() {
        new AlertDialog.Builder(this)
                //The title on the Dialog
                .setTitle("Winner")
                //The message that will appear
                .setMessage("Congratulations!" +
                        "\nPlayer 4 wins the game!\n\nClick \"Ok'\' to reset the game.")
                //What to do if the button is pressed
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //If the button is clicked then a rating bar pops up prior to resetting the game
                        ShowRatingBar();
                        //If the button is clicked then the reset method is called
                        reset2();
                    }
                }).show();
    }

    //If the game ties at the end, then this method is called in the pop() method
    //This method creates a pop-up dialog box
    public void Tie() {
        new AlertDialog.Builder(this)
                //The title on the Dialog
                .setTitle("Game Tied")
                //The message that will appear
                .setMessage("Well played!" +
                        "\nAll four players have tied!" +
                        "\n\n Click \"Play Again'\' to reset the game.")
                //What to do if the button is pressed
                .setPositiveButton("Play Again", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //do something if they click the "Close" button
                        //Once the game is over, another dialog box will appear which will ask the player to rate the game
                        //The code for this is in the "ShowDialog()" method
                        ShowRatingBar();
                    }
                }).show();
    }

    //This method creates a rating bar
    //The rating bar is then implemented and called in all the pop-up dialog box methods above
    public void ShowRatingBar() {
        //Creating the alert dialog box
        final AlertDialog.Builder RateDialog = new AlertDialog.Builder(this);
        //Creating a new rating bar which will be placed inside the dialog box
        final RatingBar rating = new RatingBar(this);
        //Setting the number of stars for rating
        rating.setNumStars(5);
        //Setting up how much the player can go up by on the ratings
        rating.setStepSize((float) 0.5);
        //Creating a linearlayout to hold the rating bar
        LinearLayout layout = new LinearLayout(this);
        //Setting width and height constraints
        LinearLayout.LayoutParams parameters = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //Adding the constraints created above to the linear layout
        layout.setLayoutParams(parameters);
        //Setting up the orientation of the linearlayout
        layout.setGravity(Gravity.CENTER_HORIZONTAL);
        //Adding the rating bar to the linear layout
        layout.addView(rating);
        //Setting up an icon for the pop up dialog box
        RateDialog.setIcon(android.R.drawable.btn_star_big_on);
        //Adding a title to the pop up dialog box
        RateDialog.setTitle("Your feedback matters. Rate us!");
        //Adding the linearlayout which contains the rating bar to the dialog box
        RateDialog.setView(layout);
        // A toast appears once the player has rated the game and clicks "Ok"
        RateDialog.setPositiveButton("ok",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        //If the rating is 0.5 or 1, a certain message appears
                        if (rating.getRating() == 0.5 || rating.getRating() == 1) {
                            Toast.makeText(getApplicationContext(), "Thank you for your feedback!", Toast.LENGTH_SHORT).show();
                        }
                        //If the rating is 1.5 or 2 or 2.5, a certain message appears
                        else if (rating.getRating() == 1.5 || rating.getRating() == 2 || rating.getRating() == 2.5) {
                            Toast.makeText(getApplicationContext(), "Hope you enjoyed the game!", Toast.LENGTH_SHORT).show();
                        }
                        //If the rating is 3 or 3.5, a certain message appears
                        else if (rating.getRating() == 3 || rating.getRating() == 3.5) {
                            Toast.makeText(getApplicationContext(), "We are glad you liked the game!", Toast.LENGTH_SHORT).show();
                        }
                        //If the rating is 4 then the message: "Wow! Thank you for giving us a 4!" appears
                        else if (rating.getRating() == 4) {
                            Toast.makeText(getApplicationContext(), "Wow! Thank you for giving us a " + (rating.getRating()) + "!", Toast.LENGTH_SHORT).show();
                        }
                        //If the rating is 4 then the message: "Wow! Thank you for giving us a 5!" appears
                        else if (rating.getRating() == 5) {
                            Toast.makeText(getApplicationContext(), "Wow! Thank you for giving us a " + (rating.getRating()) + "!", Toast.LENGTH_SHORT).show();
                        }
                        //If the rating is anything else, (specifically 4.5) then a certain message appears
                        else {
                            Toast.makeText(getApplicationContext(), "Wow! Thank you for leaving an excellent feedback!", Toast.LENGTH_SHORT).show();
                        }
                        //After the "Ok" button is pressed, the dialog box is dismissed
                        dialog.dismiss();
                    }
                });
        //If the player doesn't rate the game and clicks "Cancel" then nothing happens.
        //The pop up dialog box is dismissed
        RateDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        //Dialog box is created
        RateDialog.create();
        //Dialog box is shown on the screen
        RateDialog.show();
    }
}