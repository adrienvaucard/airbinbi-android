package com.example.airbinbi.bo;

import android.os.Parcel;
import android.os.Parcelable;

public class City implements Parcelable {
    String name;
    Picture pic;

    public City(String name, Picture pic) {
        this.name = name;
        this.pic = pic;
    }

    protected City (Parcel in) {
        name = in.readString();
        pic = in.readParcelable(Picture.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeParcelable(pic, i);
    }

    public static final Creator<City> CREATOR = new Creator<City>() {
        @Override
        public City createFromParcel(Parcel in) {
            return new City(in);
        }

        @Override
        public City[] newArray(int size) {
            return new City[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Picture getPic() {
        return pic;
    }

    public void setPic(Picture pic) {
        this.pic = pic;
    }
}
