package com.example.npmain.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song>
{
    public final static String SELECTED_ARTIST = "Selected_Artist";
    public final static String SELECTED_ALBUM = "Selected_Album";
    public final static String SELECTED_SONG = "Selected_Song";
    Artist artist;
    Album album;


    public SongAdapter(Context context, ArrayList<Song> songs)
    {
        super(context, 0, songs);
        if (songs.size() >= 1)
        {
            artist = songs.get(0).getmArtist();
            album = songs.get(0).getmAlbum();
        }

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Get the data item for this position
        final Song song = getItem(position);
        final Context context = getContext();
        final Artist songArtist = artist;
        final Album songAlbum = album;

        // Check if an existing view is being reused
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false);
        }
        //Lookup the Text View to add the Artist name
        TextView tvSong = (TextView) convertView;

        // Populate the data into the text view using the S object and pass the selected Album
        // to the next Activity
        tvSong.setText(song.getmTitle());
        tvSong.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(context, NowPlayingActivity.class);
                i.putExtra(SELECTED_SONG, song);
                i.putExtra(SELECTED_ARTIST, songArtist);
                i.putExtra(SELECTED_ALBUM, songAlbum);
                context.startActivity(i);
            }
        });
        //TextViewCompat.setTextAppearance(tvSong, R.style.SongStyle);
        tvSong.setPadding(context.getResources().getDimensionPixelSize(R.dimen.third_list_margin), // left
                context.getResources().getDimensionPixelSize(R.dimen.song_padding), // top
                context.getResources().getDimensionPixelSize(R.dimen.song_padding), // right
                context.getResources().getDimensionPixelSize(R.dimen.song_padding)); // bottom
        if ((position % 2) == 0)
        {
            tvSong.setBackgroundResource(R.color.songBGOneColor);
        }
        else
        {
            tvSong.setBackgroundResource(R.color.songBGTwoColor);
        }
        return convertView;
    }



}
