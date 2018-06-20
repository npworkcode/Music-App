package com.example.npmain.musicplayer;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.widget.TextViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ArtistAdapter extends ArrayAdapter<Artist>
{
    public final static String SELECTED_ARTIST = "Selected_Artist";

    public ArtistAdapter(Context context, ArrayList<Artist> artists)
    {
        super(context, 0, artists);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent)
    {
        // Get the data item for this position
        final Artist artist = getItem(position);
        final Context context = getContext();
        // Check if an existing view is being reused
        if (convertView == null)
        {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_artist, parent, false);
        }
        //Lookup the Text View to add the Artist name
        TextView tvArtist = (TextView) convertView;

        // Populate the data into the text view using the Artist object and pass the selected Artist
        // to the next Activity
        tvArtist.setText(artist.getmName());
        tvArtist.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent i = new Intent(context, AlbumActivity.class);
                i.putExtra(SELECTED_ARTIST, artist);
                context.startActivity(i);
            }
        });
        TextViewCompat.setTextAppearance(tvArtist, R.style.ArtistStyle);
        tvArtist.setPadding(context.getResources().getDimensionPixelSize(R.dimen.first_list_margin), // left
                            context.getResources().getDimensionPixelSize(R.dimen.first_list_margin), // top
                            context.getResources().getDimensionPixelSize(R.dimen.first_list_margin), // right
                            context.getResources().getDimensionPixelSize(R.dimen.first_list_margin)); // bottom
        if (( position % 2 ) == 0)
        {
            tvArtist.setBackgroundResource(R.color.artistBGOneColor);
        }
        else
        {
            tvArtist.setBackgroundResource(R.color.artistBGTwoColor);
        }
        return convertView;
    }



}
