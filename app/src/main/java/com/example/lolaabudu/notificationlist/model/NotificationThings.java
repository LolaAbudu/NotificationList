package com.example.lolaabudu.notificationlist.model;

import android.os.Parcel;
import android.os.Parcelable;

//Implementing Parcelable allows you to pass whole objects from one activity to another
public class NotificationThings implements Parcelable {

    private int item;
    private String description;

    public NotificationThings(int item, String description) {
        this.item = item;
        this.description = description;
    }

    private NotificationThings(Parcel in) {
        this.description = in.readString();
        this.item = in.readInt();
    }

    public void setItem(int item) {
        this.item = item;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItem() {
        return item;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(description);
        dest.writeInt(item);
    }

    public static final Creator<NotificationThings> CREATOR = new Creator<NotificationThings>() {
        @Override
        public NotificationThings createFromParcel(Parcel in) {
            return new NotificationThings(in);
        }

        @Override
        public NotificationThings[] newArray(int size) {
            return new NotificationThings[size];
        }
    };
}
