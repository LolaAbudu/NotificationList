package com.example.lolaabudu.notificationlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lolaabudu.notificationlist.controller.NotificationThingsAdapter;
import com.example.lolaabudu.notificationlist.model.NotificationThings;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView notificationThingsView;
    ImageView imageView;
    TextView textView;
    CardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notificationThingsView=findViewById(R.id.notification_list_recyclerView);
        imageView = findViewById(R.id.photo_imageView);
        textView = findViewById(R.id.description_textView);
        cardView =findViewById(R.id.textImageCardView);

        List<NotificationThings> notificationThings = new ArrayList<>();
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_airplane), "This is an airplane"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_bike), "This is a bike"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_battery_alert), "This is a dying battery"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_battery_full), "This is a full battery"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_upward_arrow), "This is an upward arrow"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_downward_arrow), "This is a downward arrow"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_forward_arrow), "This is a forward arrow"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_backward_arrow), "This is a backward arrow"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_full_moon), "This is a full moon"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_half_moon), "This is a half moon"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_key), "This is a key"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_music), "This is a music sign"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_phone_call), "This is a phone call"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_power_plug), "This is a power plug"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_shopping_cart), "This is a shopping cart"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_text_message), "This is a text message"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_voicemail), "This is a voicemail"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_wifi), "This is a wifi"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_zoom_in), "This is a zoom-in"));
        notificationThings.add(new NotificationThings(getResources().getDrawable(R.drawable.ic_action_zoom_out), "This is a zoom-out"));

        NotificationThingsAdapter notificationThingsAdapter = new NotificationThingsAdapter(notificationThings);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        notificationThingsView.setAdapter(notificationThingsAdapter);
        notificationThingsView.setLayoutManager(linearLayoutManager);
    }
}
