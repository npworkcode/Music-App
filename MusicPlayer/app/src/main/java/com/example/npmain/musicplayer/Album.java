package com.example.npmain.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;


public class Album implements Parcelable
{
    private String mAlbumName;
    private int mYear;
    private String mGenre;
    private ArrayList<Song> mSongs;

    public Album(String albumName, String genre, int year, ArrayList<Song> songs)
    {
        this.mAlbumName = albumName;
        this.mYear = year;
        this.mGenre = genre;
        this.mSongs = songs;

    }

    /**
     * Construct an Album from a Parcel
     * @param parcel Parcel
     */
    public Album(Parcel parcel)
    {
        this.mAlbumName = parcel.readString();
        this.mYear = parcel.readInt();
        this.mGenre = parcel.readString();
        this.mSongs = new ArrayList<Song>();
        parcel.readTypedList(mSongs, Song.CREATOR );
    }

    public String getmAlbumName()
    {
        return mAlbumName;
    }

    public String getmGenre()
    {
        return mGenre;
    }

    public ArrayList<Song> getmSongs()
    {
        return mSongs;
    }

    public int getmYear()
    {
        return mYear;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(mAlbumName);
        dest.writeInt(mYear);
        dest.writeString(mGenre);
        dest.writeTypedList(mSongs);
    }

    // Method to recreate an Album from a Parcel
    public static Creator<Album> CREATOR = new Creator<Album>()
    {
        @Override
        public Album createFromParcel(Parcel source)
        {
            return new Album(source);
        }

        @Override
        public Album[] newArray(int size)
        {
            return new Album[size];
        }
    };
}
