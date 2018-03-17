package com.beevishapps.vinayakv.real;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vinayak v on 10/30/2016.
 */
public class HeroPicAdapter extends RecyclerView.Adapter<HeroPicAdapter.MyViewHolder> {

    Context context;
    boolean online;
    private List<newResponse.PVCBean.HerosBean> aAwarditem = new ArrayList<newResponse.PVCBean.HerosBean>();

//    public HeroPicAdapter(List<Hero_Pics> AwardsList, Context context) {
//        this.Heros_picsList = AwardsList;
//        this.context = context;
//    }


    public HeroPicAdapter(Context context, List<newResponse.PVCBean.HerosBean> aAwarditem) {
        this.context = context;
        this.aAwarditem = aAwarditem;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hero_pics, parent, false);


        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {


        int imagesize = 600;

        //Hero_Pics heropic = Heros_picsList.get(position);//..................................... for pallete color

        newResponse.PVCBean.HerosBean item = aAwarditem.get(position);

        holder.name.setText(item.getName());
        holder.operation.setText(item.getOperation());
        holder.year.setText(item.getTitle());

        String imageurl = item.getUrl();

       if(imageurl.equalsIgnoreCase(""))
        {
            imageurl="http://4.bp.blogspot.com/-mQuqincsGc0/TlFYoP7coVI/AAAAAAAAATY/Mt8YbkXiamU/s1600/21UNIFORM-1313799420139-articleLarge-v2.jpg";
        }


        Picasso.with(holder.imageView.getContext())
                .load(imageurl)
                .placeholder(R.drawable.def8)
                .error(R.drawable.def8)

                .resize(imagesize, imagesize)
//                .centerInside()
               .centerCrop()
                .noFade()
                .into(holder.imageView);


//        holder.placeNameHolder.setBackgroundColor(context.getResources().getColor(android.R.color.black));
//        holder.placeNameHolder.setBackgroundColor(item.pColor);//..................................... for pallete color


        // Bitmap photo = BitmapFactory.decodeResource(context.getResources(), heropic.hero_image());
//
//        Palette.from(photo).generate(new Palette.PaletteAsyncListener() {
//            public void onGenerated(Palette palette) {
//                int bgColor = palette.getMutedColor(context.getResources().getColor(android.R.color.black));
//                holder.placeNameHolder.setBackgroundColor(bgColor);
//            }
//        });
//
//

        //   holder.imageView.setImageResource(R.drawable.ac3);


//        Bitmap photo = BitmapFactory.decodeResource(context.getResources(),holder.imageView.getDrawable());

       /* Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int bgColor = palette.getMutedColor(context.getResources().getColor(android.R.color.black));
                holder.placeNameHolder.setBackgroundColor(bgColor);
            }
        });*/


    }

    @Override
    public int getItemCount() {
        return aAwarditem.size();
    }


    private void setAnimation(View viewToAnimate) {
        // If the bound view wasn't previously displayed on screen, it's animated
//        if (position > lastPosition)
//        {
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        //animation.setStartOffset(50);

        viewToAnimate.startAnimation(animation);
        //lastPosition = position;
//        }
    }

    private void clearAnimation(View view){
        view.clearAnimation();
    }

    @Override
    public void onViewAttachedToWindow(MyViewHolder holder) {

        super.onViewAttachedToWindow(holder);

        setAnimation(holder.itemView);//setting animation to items while loading

    }

    @Override
    public void onViewDetachedFromWindow(MyViewHolder holder) {
        super.onViewDetachedFromWindow(holder);
        clearAnimation(holder.itemView);

    }


//    @Override
//    public int getItemCount() {
//        return Heros_picsList.size();
//    }


    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView name, operation, year;
        public ImageView imageView;
        public View placeNameHolder;

        public MyViewHolder(View itemView) {
            super(itemView);


            name = (TextView) itemView.findViewById(R.id.Name);
            operation = (TextView) itemView.findViewById(R.id.Operation);
            year = (TextView) itemView.findViewById(R.id.Year);

            imageView = (ImageView) itemView.findViewById(R.id.Hero_imageView);

            placeNameHolder = itemView.findViewById(R.id.placeNameHolder);


            itemView.setClickable(true);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {


            v.setTransitionName("imagetransition");

            ActivityOptionsCompat options =
                    ActivityOptionsCompat.makeSceneTransitionAnimation((Activity) context, v, v.getTransitionName());

            newResponse.PVCBean.HerosBean p = aAwarditem.get(getAdapterPosition());

            Intent i = new Intent(context, Pvc_Details.class);

            i.putExtra("name_of_extra", p);


            context.startActivity(i, options.toBundle());


        }
    }
}
