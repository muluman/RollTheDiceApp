package com.example.mydiceapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView dice1 = findViewById(R.id.dice1);
        final ImageView dice2 = findViewById(R.id.dice2);

        final int [] diceImages = {R.drawable.dice1, R.drawable.dice2, R.drawable.dice3, R.drawable.dice4, R.drawable.dice5, R.drawable.dice6};

        Button rollButton = findViewById(R.id.rollDiceButton);

        final MediaPlayer mp = MediaPlayer.create(this, R.raw.dice_sound);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.i("MyDiceApp", "Roll Button is pressed now!");

                Random rndObject = new Random();
                int firstRandomNumber = rndObject.nextInt(6);
                int secondRandomNumber = rndObject.nextInt(6);

                dice1.setImageResource(diceImages[firstRandomNumber]);
                dice2.setImageResource(diceImages[secondRandomNumber]);

                Log.i("MyDiceApp", "My number is... " + firstRandomNumber + " and " + secondRandomNumber);

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice1));

                YoYo.with(Techniques.Shake)
                        .duration(400)
                        .repeat(0)
                        .playOn(findViewById(R.id.dice2));

                mp.start();
            }
        });
    }
}