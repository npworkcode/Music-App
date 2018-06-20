package com.example.npmain.musicplayer;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class NowPlaying extends AppCompatActivity
{
    public final static String SELECTED_ARTIST = "Selected_Artist";
    public final static String SELECTED_ALBUM = "Selected_Album";
    public final static String SELECTED_SONG = "Selected_Song";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);
        Artist artist = getIntent().getParcelableExtra(SELECTED_ARTIST);
        Album album = getIntent().getParcelableExtra(SELECTED_ALBUM );
        Song song = getIntent().getParcelableExtra(SELECTED_SONG);
        initializeUI(artist, album, song);
    }

    private void initializeUI(Artist artist, Album album, Song song)
    {
        TextView artistTextView = findViewById(R.id.now_playing_artist);
        final Artist nowPlayingArtist = artist;
        // Create the artist TextView and set the OnClickListener to load the MusicLibrary Activity
        artistTextView.setText(nowPlayingArtist.getmName());
        artistTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(NowPlaying.this, MusicLibrary.class);
                startActivity(i);
            }
        });
        TextViewCompat.setTextAppearance(artistTextView, R.style.ArtistStyle);
        artistTextView.setBackgroundResource(R.color.artistBGOneColor);
        // Create the album TextView and set the OnClickListener to load the Album Activity
        TextView albumTextView = findViewById(R.id.now_playing_album);
        albumTextView.setText(album.getmAlbumName());
        albumTextView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(NowPlaying.this,AlbumActivity.class);
                i.putExtra(SELECTED_ARTIST, nowPlayingArtist);
                startActivity(i);
            }
        });
        TextViewCompat.setTextAppearance(albumTextView, R.style.AlbumStyle);
        albumTextView.setBackgroundResource(R.color.albumBGColor);
        TextView songTextView = findViewById(R.id.now_playing_song);
        songTextView.setText(song.getmTitle());
        TextViewCompat.setTextAppearance(songTextView, R.style.SongStyle);
        songTextView.setBackgroundResource(R.color.songBGOneColor);
    }


}
