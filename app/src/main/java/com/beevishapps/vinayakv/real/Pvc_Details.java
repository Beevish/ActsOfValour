package com.beevishapps.vinayakv.real;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.transition.TransitionInflater;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.amlcurran.showcaseview.OnShowcaseEventListener;
import com.github.amlcurran.showcaseview.ShowcaseView;
import com.github.amlcurran.showcaseview.targets.ViewTarget;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Locale;

public class Pvc_Details extends AppCompatActivity implements OnShowcaseEventListener {


    private static final float ALPHA_DIM_VALUE = 0.1f;
    private static final String TAG = "Pvc_Details";
    Toolbar tbar;
    TextView descrip, descrip1, descrip2, descrip3, reference, marqueetext;
    TextToSpeech t1;
    MediaPlayer mp;
    Button button1, button2, button3, button4, button5;
    TextView textView;
    ShowcaseView sv;
    int MAX_SPEECH_ITEM_CHAR_LENGTH = 3999;
    NestedScrollView Nsv;
    int play_button_pressed = 0;
    private AppBarLayout abar;
    private ImageView collap_imgView;
    private newResponse.PVCBean.HerosBean p;
    private ArrayList<String> strings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        getWindow().setSharedElementEnterTransition(TransitionInflater.from(this).inflateTransition(R.transition.shared_element_transition_a));
        setContentView(R.layout.activity_pvc_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        Intent i = getIntent();
        p = i.getParcelableExtra("name_of_extra");


        Nsv = (NestedScrollView) findViewById(R.id.nestedscrollview);
        abar = (AppBarLayout) findViewById(R.id.app_bar);
        tbar = (Toolbar) findViewById(R.id.toolbar);
        collap_imgView = (ImageView) findViewById(R.id.collap_imgView);
        descrip = (TextView) findViewById(R.id.descrip);
        descrip1 = (TextView) findViewById(R.id.descrip1);
        descrip2 = (TextView) findViewById(R.id.descrip2);
        descrip3 = (TextView) findViewById(R.id.descrip3);
        reference = (TextView) findViewById(R.id.reference);
        marqueetext = (TextView) findViewById(R.id.marqueetext);

        tbar.setTitle(p.getName());
        descrip.setText(p.getDescription());
        descrip1.setText(p.getDescription1());
        descrip2.setText(p.getDescription2());
        descrip3.setText(p.getDescription3());
        reference.setText(p.getMoredescription());


// ...................................................................................text to speech in floating button...................................................................................

        t1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {


                    Locale locale = new Locale("en", "IN");//..............................Indian Accent......................................

                    t1.setLanguage(locale);


                }
            }
        });


        ImageView icon = new ImageView(this); // Create an icon


        icon.setImageDrawable(getDrawable(R.drawable.chakra1));


        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)


                .setContentView(icon)
                .build();
//actionButton

        SubActionButton.Builder itemBuilder1 = new SubActionButton.Builder(this);
        ImageView itemIcon1 = new ImageView(this);
        SubActionButton button1 = itemBuilder1.setContentView(itemIcon1).build();

// repeat many times:Button 1

        itemIcon1.setImageDrawable(getDrawable(R.drawable.ic_play_arrow));


        //..................button 1.............................................. for starting the tts.......................................................................


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (play_button_pressed == 0) {
                    play_button_pressed = 1;
                    mp = MediaPlayer.create(getApplicationContext(), R.raw.textbackaudio);//.......................background music for text
                    mp.start();

                    mp.setVolume((float) 0.3, (float) 0.3);//..........controlling the volume of bacground music
                    mp.setLooping(true);
                    String toSpeak = p.getDescription3();//...................................text to speech.......................................

//                    if (descrip3.length() >= MAX_SPEECH_ITEM_CHAR_LENGTH) {
                    //........................................................................spilting string into chunks.....................................
                    strings = new ArrayList<String>();
                    int index = 0, count = 0;
                    while (index < p.getDescription3().length()) {
                        count++;
                        strings.add(p.getDescription3().substring(index, p.getDescription3().indexOf(".", index)));
                        index = p.getDescription3().indexOf(".", index) + 1;
                    }


                    t1.setSpeechRate((float) 0.8);//...................................controlling the speed of reading.....................
                    Bundle params = new Bundle();
                    params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
//                    t1.speak(strings.get(0), TextToSpeech.QUEUE_FLUSH, params, "0");//.............misses the first chunk therefore oth element playing it first
//
//                    for (int i = 1; i < count; i++) {
//                        t1.speak(strings.get(i), TextToSpeech.QUEUE_ADD, params, i + "");
//                    }


//..............................................................speaking started  working while the words are spoken...............................................................
                    t1.setOnUtteranceProgressListener(new UtteranceProgressListener() {
                        String highlightedText = "";


                        @Override
                        public void onStart(String s) {//.........................................................when tts starts to speak..................
                            highlightedText = "";
                            Log.w("::onStart:hiihih::", s);

                            try {

                                int i = Integer.parseInt(s);

                                for (int j = 0; j < strings.size(); j++) {
                                    Log.d(TAG, "onStart: " + strings.get(j));
                                    if (i == j) {
                                        highlightedText = highlightedText + "<br>" + "<font color='red'>" + strings.get(j) + "</font>" + "." + "<br>";
                                    } else {
                                        highlightedText = highlightedText + "<br>" + strings.get(j) + ".";
                                    }
                                }


                            } catch (NumberFormatException e) {
                                highlightedText = p.getDescription3();
                            } finally {

                                runOnUiThread(new Runnable() {

                                    public void run() {
                                        descrip3.setText(Html.fromHtml(highlightedText));
                                    }
                                });

                            }

                        }

                        @Override
                        public void onDone(String s) {//...........................................................when tts is finished speaking.....................
                            Log.w("::onDone:hiihih::", s);
                            Log.w("::onDone:hiihih::", String.valueOf(strings.size()));
                            //...........................................................................calculating the length of the string to stop background music...........................................................
                            int i = Integer.parseInt(s);
                            int j = Integer.parseInt(String.valueOf(strings.size()));
                            if (i == j - 1) {
                                mp.stop();

                            }

                            //mp.stop();
                        }


                        @Override
                        public void onError(String s) {
                            Log.d(TAG, "onError() called with: s = [" + s + "]");

                        }


                    });

                    t1.speak(strings.get(0), TextToSpeech.QUEUE_FLUSH, params, "0");//.............misses the first chunk therefore oth element playing it first

                    for (int i = 1; i < count; i++) {
                        t1.speak(strings.get(i), TextToSpeech.QUEUE_ADD, params, i + "");
                    }



                }

            }
        });


        //Button5.............................

        SubActionButton.Builder itemBuilder5 = new SubActionButton.Builder(this);
// repeat many times:Button 5
        ImageView itemIcon5 = new ImageView(this);
        itemIcon5.setImageDrawable(getDrawable(R.drawable.ic_stop));

        SubActionButton button5 = itemBuilder5.setContentView(itemIcon5).build();

//.....button5...................................................................for stopping the tts


        button5.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {

                if (play_button_pressed == 1) {
                    play_button_pressed = 0;
                    t1.stop();
                    mp.stop();
                }


            }


        });


        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(button1)
//                .addSubActionView(button2)
//                .addSubActionView(button3)
//                .addSubActionView(button4)
                .addSubActionView(button5)
                // ...

                .attachTo(actionButton)
                .build();

        RelativeLayout.LayoutParams lps = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        lps.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        lps.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
        int margin = ((Number) (getResources().getDisplayMetrics().density * 12)).intValue();
        lps.setMargins(margin, margin, margin, margin);


        ViewTarget target = new ViewTarget(R.id.fab, this);

        sv = new ShowcaseView.Builder(this)

                .withHoloShowcase()
                .setTarget(target)
                .setContentTitle("Special Feature...!")
                .setContentText("To Play or Stop Audio")

                .setStyle(R.style.CustomShowcaseTheme2)
                .setShowcaseEventListener(this)
                .singleShot(1)
//                .replaceEndButton(R.layout.view_custom_button)
                .build();
        sv.setButtonPosition(lps);


        //.....................................................................................for customized fonts...................................
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/tomnr.ttf");
        descrip3.setTypeface(custom_font);
        reference.setTypeface(custom_font);
        reference.setTypeface(reference.getTypeface(), Typeface.BOLD);//.......keeping the typeface as it is and changing the style to Bold............................
        marqueetext.setTypeface(custom_font);

        String imageurl = p.getUrl();

        Log.d("output:::::::::", imageurl);


        if (imageurl.equalsIgnoreCase("")) {
            imageurl = "http://4.bp.blogspot.com/-mQuqincsGc0/TlFYoP7coVI/AAAAAAAAATY/Mt8YbkXiamU/s1600/21UNIFORM-1313799420139-articleLarge-v2.jpg";
        }


        Picasso.with(this)
                .load(imageurl)


                .error(R.drawable.def8)
                .noFade()
                .into(collap_imgView);


    }

    private void color1stsentence() {

        String fullsen = descrip3.getText().toString();

        String firstsen = fullsen.substring(0, fullsen.indexOf("."));


    }

    @Override
    protected void onStop() {
        if (mp != null) {


            mp.stop();
        }
        super.onStop();
    }

    public void onPause() {
        if (t1 != null && mp != null) {
            t1.stop();

            mp.stop();
        }
        super.onPause();
    }


    //@TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private void dimView(View view) {
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        // view.setAlpha(ALPHA_DIM_VALUE);
        //}
    }

    @Override
    public void onShowcaseViewHide(ShowcaseView showcaseView) {
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
        //listView.setAlpha(1f);
        //}
        // buttonBlocked.setText(R.string.button_show);
        //buttonBlocked.setEnabled(false);
    }

    @Override
    public void onShowcaseViewDidHide(ShowcaseView showcaseView) {
    }

    @Override
    public void onShowcaseViewShow(ShowcaseView showcaseView) {
        //dimView(listView);
        //buttonBlocked.setText(R.string.button_hide);
        //buttonBlocked.setEnabled(true);
    }

    @Override
    public void onShowcaseViewTouchBlocked(MotionEvent motionEvent) {

    }


}
