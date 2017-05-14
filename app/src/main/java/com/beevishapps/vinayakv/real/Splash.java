package com.beevishapps.vinayakv.real;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by Vinayak v on 14/11/16.
 */
public class Splash extends Activity {

    private Context c;
    MediaPlayer mp;

    private RelativeLayout rl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.splash);

        final ImageView iv = (ImageView) findViewById(R.id.imageView2);

        rl=(RelativeLayout)findViewById(R.id.rl);


        final Animation an = AnimationUtils.loadAnimation(getBaseContext(), R.anim.rotate);
        final Animation an2 = AnimationUtils.loadAnimation(getBaseContext(), R.anim.abc_fade_out);


        // fade in textview animation
        final TextView mSwitcher = (TextView) findViewById(R.id.textView);
        final TextView mSwitcher2 = (TextView) findViewById(R.id.textView2);


       // String text = "<font color=#FF5722>Real</font> <font color=#4CAF50>Heros</font>";
        String text2 = "Acts Of";
        String text="VALOUR";

        //...............APP Name:VALORA; VALOURANS.....................................................................................................

//        String text="It is only when we FORGET their Acts Of Bravery that soldiers die.";
//        String text2 = "Soldiers don't die when bullets pierce their hearts and heads through their olive green shirts and wooden balaclaves.\nThey don't die when they fall before an enemy onslaught, or even when they get buried in trenches,staining the earth with their crimson blood.";
//        String text2 = "Soldiers don't die when bullets pierce their hearts and heads through their olive green shirts or even when they get buried in trenches,staining the earth with their crimson blood.It is only when we FORGET their Acts Of Bravery that soldiers die.";

        mSwitcher.setText(Html.fromHtml(text));
        mSwitcher2.setText(Html.fromHtml(text2));



        final Animation in = new AlphaAnimation(0.0f, 1.0f);
        in.setDuration(7000);
        mSwitcher.startAnimation(in);

        mSwitcher2.startAnimation(in);

        iv.startAnimation(an);

        mp = MediaPlayer.create(getApplicationContext(), R.raw.h4);             //..............audio of helicoper while spinning
        mp.start();


        an.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

                iv.startAnimation(an2);

                mp.stop();                                 //.........stop the audio


                finish();


                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        rl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mp.stop();                                 //.........stop the audio

                finish();


                Intent i = new Intent(getBaseContext(), MainActivity.class);
                startActivity(i);

            }
        });
    }
}
