package com.example.npmain.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.ArrayList;

public class AlbumActivity extends AppCompatActivity
{
    public final static String SELECTED_ARTIST = "Selected_Artist";
    LinearLayout albumLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album);
        Artist artist =  this.getIntent().getParcelableExtra(SELECTED_ARTIST);
        initializeUI(artist);
    }

    private void initializeUI(Artist artist)
    {
        albumLayout = findViewById(R.id.album_list);
        final Context context = this;
        // Set up the artist textView and add to LinearLayout
        TextView artistTextView = new TextView(context);
        artistTextView.setText(artist.getmName());
        TextViewCompat.setTextAppearance(artistTextView,R.style.ArtistStyle);
        artistTextView.setBackgroundResource(R.color.artistBGOneColor);
        artistTextView.setPadding(context.getResources().getDimensionPixelSize(R.dimen.first_list_margin), // left
                context.getResources().getDimensionPixelSize(R.dimen.first_list_margin), // top
                context.getResources().getDimensionPixelSize(R.dimen.first_list_margin), // right
                context.getResources().getDimensionPixelSize(R.dimen.first_list_margin)); // bottom
        artistTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(context, MusicLibrary.class);
                context.startActivity(i);
            }
        });
        albumLayout.addView(artistTextView);
        /*
        For each album of the artist, show the title of the album in a TextView
        and all the songs in the album in a ListView
         */

        for (Album album : artist.getmAlbums())
        {
           TextView albumTextView = new TextView(context);
            albumTextView.setText(album.getmAlbumName());
            TextViewCompat.setTextAppearance(albumTextView, R.style.AlbumStyle);
            albumTextView.setBackgroundResource(R.color.albumBGColor);
            albumTextView.setPadding(this.getResources().getDimensionPixelSize(R.dimen.second_list_margin), // left
                    this.getResources().getDimensionPixelSize(R.dimen.second_list_margin), // top
                    this.getResources().getDimensionPixelSize(R.dimen.second_list_margin), // right
                    this.getResources().getDimensionPixelSize(R.dimen.second_list_margin)); // bottom

            albumLayout.addView(albumTextView);
            ArrayList<Song> songs = album.getmSongs();
            if (songs.size() >= 1)
            {
                songs.get(0).setmArtist(artist);
                songs.get(0).setmAlbum(album);
            }
            SongAdapter songAdapter = new SongAdapter(context, songs);
            // ListView songListView = (ListView) LayoutInflater.from(context).inflate(R.layout.listview, null, false);
            ListView songListView = new ListView(context);
            albumLayout.addView(songListView);
            songListView.setAdapter(songAdapter);



        }




    }

}
