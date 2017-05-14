package com.beevishapps.vinayakv.real;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Vinayak v on 9/18/2016.
 */
public class AwardsAdapter extends RecyclerView.Adapter<AwardsAdapter.MyViewHolder> {


    public List<Awards> AwardsList;
    private Context c;

    public AwardsAdapter(List<Awards> AwardsList, Context c) {
        this.AwardsList = AwardsList;
        this.c = c;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.awardcards, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {


        Awards award = AwardsList.get(position);
        holder.title.setText(award.getTitle());
        holder.text1.setText(award.getText1());
        holder.text2.setText(award.getText2());
        //holder.imageView.setImageDrawable(ContextCompat.getDrawable(holder.imageView.getContext(), R.drawable.d1));

        int wh=500;

        Picasso.with(holder.imageView.getContext())
                .load(award.getImageset())
                .resize(wh,wh)
                .centerCrop()


                .into(holder.imageView);


        //holder.Maincard.setBackgroundColor(award.pcolor);       //.................................setting pallete color to specified compents..for example cardviews background.
        //holder.title.setTextColor(award.pcolor);

Log.w("output:::::", String.valueOf(award.pcolor));

       // holder.myview.setBackgroundResource(R.color.colorAccent);
      // holder.myview.setBackgroundColor(award.pcolor);//.....................setting the pallete color in the home screen
//
//
//        holder.myview.getBackground().setAlpha(170);


    }


    private void setAnimation(View viewToAnimate) {
        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
        Animation animation = AnimationUtils.loadAnimation(c, android.R.anim.slide_in_left);
        animation.setStartOffset(100);

        viewToAnimate.startAnimation(animation);
        //lastPosition = position;
//        }
    }

    @Override
    public void onViewAttachedToWindow(MyViewHolder holder) {

        super.onViewAttachedToWindow(holder);

        setAnimation(holder.itemView);//setting animation to items while loading

    }

    private void clearAnimation(View view){
        view.clearAnimation();
    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        clearAnimation(holder.itemView);
    }

    @Override
    public int getItemCount() {
        return AwardsList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView title, text1, text2;
        public ImageView imageView;
        public View Maincard;
        public CardView myview;

        public MyViewHolder(View itemView) {
            super(itemView);

            //Maincard = (LinearLayout) itemView.findViewById(R.id.Maincard);
            title = (TextView) itemView.findViewById(R.id.title);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            text1 = (TextView) itemView.findViewById(R.id.text1);
            text2 = (TextView) itemView.findViewById(R.id.text2);

           // myview=(CardView) itemView.findViewById(R.id.myview);

            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {




            Awards a = AwardsList.get(getAdapterPosition());

            Log.w("Output::::::::::", String.valueOf(a));

            if(a.getTitle()=="Param Veer Chakra")
                        {
                            Intent pvc = new Intent(c, Pvc_Activity.class);
                            c.startActivity(pvc);

                        }
                        if(a.getTitle()=="Ashoka Chakra")
                        {
                            Intent ac = new Intent( c, Ac_Activity.class);
                            c.startActivity(ac);

                        }
                        if(a.getTitle()=="Maha Veer Chakra")
                        {
                            Intent mvc = new Intent( c, Mvc_Activity.class);
                            c.startActivity(mvc);
                        }
                        if(a.getTitle()=="Veer Chakra")
                        {
                            Intent kc = new Intent(c, Kc_Activity.class);
                            c.startActivity(kc);
                        }


        }
    }
}
