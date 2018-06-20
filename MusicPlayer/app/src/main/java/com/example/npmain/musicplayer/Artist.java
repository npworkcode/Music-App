package com.example.npmain.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Artist implements Parcelable
{
    private String mName;
    private ArrayList<Album> mAlbums;


    public Artist(String artistName, ArrayList<Album> albums)
    {
        this.mName = artistName;
        this.mAlbums = albums;
    }

    public Artist(Parcel parcel)
    {
        this.mName = parcel.readString();
        this.mAlbums = new ArrayList<Album>();
        parcel.readTypedList(mAlbums, Album.CREATOR);
    }

    public ArrayList<Album> getmAlbums()
    {
        return mAlbums;
    }

    public String getmName()
    {
        return mName;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    // Required method to write to Parcel
    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(mName);
        dest.writeTypedList(mAlbums);
    }

    // Method to recreate an Artist from a Parcel
    public static Creator<Artist> CREATOR = new Creator<Artist>()
    {
        @Override
        public Artist createFromParcel(Parcel source)
        {
            return new Artist(source);
        }

        @Override
        public Artist[] newArray(int size)
        {
            return new Artist[size];
        }
    };
}
