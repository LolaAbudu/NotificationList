package com.example.lolaabudu.notificationlist.model;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.DrawableRes;


public class NotificationThings  {
    //@DrawableRes int drawable  another way to call your drawable
    Drawable item;
    String description;

    public NotificationThings(Drawable item, String description){
        this.item=item;
        this.description=description;
    }

//    protected NotificationThings(Parcel in) {
//        description = in.readString();
//    }

    public void setItem(Drawable item) {
        this.item = item;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Drawable getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

//    @Override
//    public int describeContents() {
//        return 0;
//    }

//    @Override
//    public void writeToParcel(Parcel dest, int flags) {
//        dest.writeString(description);
//
//    }

//    public static final Creator<NotificationThings> CREATOR = new Creator<NotificationThings>() {
//        @Override
//        public NotificationThings createFromParcel(Parcel in) {
//            return new NotificationThings(in);
//        }
//
//        @Override
//        public NotificationThings[] newArray(int size) {
//            return new NotificationThings[size];
//        }
//    };
}
