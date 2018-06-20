package com.example.npmain.musicplayer;

import android.os.Parcel;
import android.os.Parcelable;

public class Song implements Parcelable
{
    private String mTitle;
    private Double mTrackLength;
    private Artist mArtist;
    private Album mAlbum;



    public Song(String title, Double trackLength)
    {
        this.mTitle = title;
        this.mTrackLength = trackLength;
    }

    /** Construct a Song from a Parcel
     * @param in Parcel
     */
    public Song(Parcel in)
    {
        this.mTitle = in.readString();
        this.mTrackLength = in.readDouble();
    }

    public String getmTitle()
    {
        return mTitle;
    }

    public Double getmTrackLength()
    {
        return mTrackLength;
    }

    public void setmArtist(Artist mArtist)
    {
        this.mArtist = mArtist;
    }

    public void setmAlbum(Album mAlbum)
    {
        this.mAlbum = mAlbum;
    }
    public Artist getmArtist()
    {
        return mArtist;
    }

    public Album getmAlbum()
    {
        return mAlbum;
    }

    @Override
    public int describeContents()
    {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags)
    {
        dest.writeString(mTitle);
        dest.writeDouble(mTrackLength);
    }

    // Method to recreate a Song from a Parcel
    public static Creator<Song> CREATOR = new Creator<Song>()
    {
        @Override
        public Song createFromParcel(Parcel source)
        {
            return new Song(source);
        }

        @Override
        public Song[] newArray(int size)
        {
            return new Song[size];
        }
    };
}
