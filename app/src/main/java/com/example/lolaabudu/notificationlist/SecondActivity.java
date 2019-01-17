package com.example.lolaabudu.notificationlist;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lolaabudu.notificationlist.model.NotificationThings;


public class SecondActivity extends AppCompatActivity {

    private TextView textView;
    private ImageView imageView;
    private Button notificationButton;
    private SharedPreferences sharedPreferences;
    private NotificationManager notificationManager;
    private final int NOTIFICATION_ID = 0;
    private static final String SHARED_PREFS_KEY = "com.example.lolaabudu.sharedpreferences2";
    private static final String PRIMARY_CHANNEL_ID = "primary_notification_channel";
    private static final String ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notificationlist.ACTION_UPDATE_NOTIFICATION";

    NotificationThings notificationThings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textView = findViewById(R.id.description_textView_secondActivity);
        imageView = findViewById(R.id.photo_imageView_secondActivity);
        notificationButton = findViewById(R.id.notification_button_secondActivity);
        sharedPreferences = getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);


        Intent intent = getIntent();
        textView.setText(intent.getStringExtra("things"));

        //serializable and parseable

//        Bundle imageBundle = getIntent().getExtras();
//        int img;
//        img = imageBundle.getInt("image");
//        imageView.setImageResource(img);

        //Picasso.get().load(intent.getStringExtra("image")).into(imageView);

//        boolean isNew = false;
//        Intent i = getIntent();
//        if(i == null){
//            isNew= i.getBooleanExtra("isNew", false);
//            Log.d("tag", "isNew" + isNew);
//        }
//        if(getIntent() != null && getIntent().getExtras() != null){
//
//        }

//        Bundle imageBundle = getIntent().getExtras();
//        int pic = imageBundle.getInt("things2");
//        Drawable img = imageBundle.get
//        imageView.setImageResource(pic);


//        Bundle imageBundle = this.getIntent().getExtras();
//        int image = imageBundle.getInt("images");
//        imageView.setImageResource(image);

//         Bundle bundle=this.getIntent().getExtras();
//            int pic=bundle.getInt("image");
//            imageView.setImageResource(pic);

//        Bundle bundle=this.getIntent().getExtras();
//        imageView.setImageResource(bundle);

        notificationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (sharedPreferences.contains(textView.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "You have already sent this notification", Toast.LENGTH_SHORT).show();
                } else {
                    sendNotification();
                }
            }
        });

        createNotificationChannel();
    }

    private void sendNotification() {
        NotificationCompat.Builder notifyBuilder = getNotificationBuilder();
        notificationManager.notify(NOTIFICATION_ID, notifyBuilder.build());
        Intent notifyIntent = new Intent(ACTION_UPDATE_NOTIFICATION);
        PendingIntent updatePendingIntent = PendingIntent.getBroadcast(this, NOTIFICATION_ID, notifyIntent, PendingIntent.FLAG_ONE_SHOT);
        notifyBuilder.addAction(R.drawable.ic_action_airplane, "Update Notification", updatePendingIntent);
        Log.d("Notify", "It works");

        //this saves into the shared preference after the onClick of the button the unique textView message as the key and true as its value
        //using shared preference to save the one instance of the notification
        sharedPreferences.edit().putBoolean(textView.getText().toString(), true).apply();
    }

    private NotificationCompat.Builder getNotificationBuilder() {
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent notificationPendingIntent = PendingIntent.getActivity(this,
                NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);

        NotificationCompat.Builder notifyBuilder = new NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
                .setContentTitle("You've been notified!")
                .setContentText("This is your notification text.")
                .setSmallIcon(R.drawable.ic_action_airplane)    //the icon that shows in the notification drawer (THIS IS THE ONLY THING YOU NEED FOR A NOTIFICATION, EVERYTHING ELSE IS OPTIONAL AND PREFERENCE)
                .setContentIntent(notificationPendingIntent)   //aka tap action, aka what happens when the user taps the notification tab; passes in the pending Intent
                .setAutoCancel(true)   //the notification cancels itself after an action is performed such as the user tapping it
                .setPriority(NotificationCompat.PRIORITY_HIGH)   //for API 26 and up
                .setDefaults(NotificationCompat.DEFAULT_ALL);
        return notifyBuilder;
    }

    private void createNotificationChannel() {
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
                android.os.Build.VERSION_CODES.O) {

            NotificationChannel notificationChannel = new NotificationChannel(PRIMARY_CHANNEL_ID,
                    "Create Notification", NotificationManager
                    .IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.enableVibration(true);
            notificationChannel.setDescription("Notification from Notification List");
            notificationManager.createNotificationChannel(notificationChannel);
        }
    }
}
