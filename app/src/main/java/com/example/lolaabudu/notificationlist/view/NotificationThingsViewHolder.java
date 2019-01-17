package com.example.lolaabudu.notificationlist.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.notificationlist.R;
import com.example.lolaabudu.notificationlist.SecondActivity;
import com.example.lolaabudu.notificationlist.model.NotificationThings;

import retrofit2.Retrofit;

public class NotificationThingsViewHolder extends RecyclerView.ViewHolder {

    private static final String TAG = "image_call";
    private TextView description;
    private ImageView item;
    private SharedPreferences sharedPreferences;
    private Intent intent;

    public NotificationThingsViewHolder(@NonNull View itemView) {
        super(itemView);
        description = itemView.findViewById(R.id.description_textView);
        item = itemView.findViewById(R.id.photo_imageView);
        sharedPreferences = itemView.getContext().getApplicationContext().getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    public void onBind(final NotificationThings notificationThings){
        description.setText(notificationThings.getDescription());
        item.setImageDrawable(notificationThings.getItem());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //shared prefernce is used to save the one instance of the notification
                //put the shared prefernce that says if get shared preference.contains key,  then do the Toast, else put the intent
                intent = new Intent(v.getContext(), SecondActivity.class);
                intent.putExtra("things", notificationThings.getDescription());

                //intent.putExtra("things2", item.getId());


                Bundle imageBundle = new Bundle();
                imageBundle.putInt("image", item.getId());
                intent.putExtras(imageBundle);



                v.getContext().startActivity(intent);


            }
        });
    }
}
