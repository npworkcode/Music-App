package com.example.npmain.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import java.util.ArrayList;



public class MusicLibraryActivity extends AppCompatActivity
{
    Artist artistU2;
    Artist artistMichaelJackson;
    ArrayList<Artist> artists;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_library);
        artists = new ArrayList<>();
        artistU2 = initializeU2();
        artistMichaelJackson = initializeMichaelJackson();
        artists.add(artistU2);
        artists.add(artistMichaelJackson);
        ArtistAdapter artistAdapter = new ArtistAdapter(this, artists);
        ListView libraryListView = findViewById(R.id.music_library);
        libraryListView.setAdapter(artistAdapter);

    }

    private Artist initializeU2()
    {
        ArrayList<Song> songs = new ArrayList<>();
        songs.add(new Song("Where The Streets Have No Name", 5.38));
        songs.add(new Song ("I Still Haven't Found What I'm Looking For", 4.38));
        songs.add(new Song("With Or Without You", 4.56));
        songs.add(new Song("Bullet The Blue Sky", 4.32));
        songs.add( new Song("Running To Stand Still", 4.17));
        songs.add( new Song("Red Hill Mining Town", 4.53));
        songs.add( new Song("In God's Country", 2.56));
        songs.add( new Song("Trip Through Your Wires", 3.32));
        songs.add(new Song("One Tree Hill", 5.23));
        songs.add(new Song("Exit", 4.13));
        songs.add(new Song("Mothers Of The Disappeared", 5.12));
        ArrayList<Album> albums = new ArrayList<>();
        albums.add( new Album("The Joshua Tree", "Rock", 1987, songs));

        songs = new ArrayList<Song>();
        songs.add(new Song("Vertigo", 3.14));
        songs.add(new Song ("Miracle Drug", 3.59));
        songs.add(new Song("Sometimes You Can't Make It On Your Own", 5.08));
        songs.add(new Song("Love And Peace Or Else", 4.50));
        songs.add( new Song("City Of Blinding Lights", 5.47));
        songs.add( new Song("All Because Of You", 3.39));
        songs.add( new Song("A Man And A Woman", 4.30));
        songs.add( new Song("Crumbs From Your Table", 5.03));
        songs.add(new Song("One Step Closer", 3.51));
        songs.add(new Song("Original Of The Species", 4.41));
        songs.add(new Song("Yahweh", 4.21));
        albums.add( new Album("How To Dismantle An Atomic Bomb", "Rock", 2004, songs));

       return new Artist( "U2", albums);

    }
    private Artist initializeMichaelJackson()
    {
        ArrayList<Song> songs = new ArrayList<>();
        ArrayList<Album> albums = new ArrayList<>();

        songs.add(new Song("Rockin' Robin", 2.32));
        songs.add(new Song ("Got To Be There", 3.23));
        songs.add(new Song("Ben", 2.45));
        songs.add(new Song("Love Is Here And Now You're Gone", 2.52));
        songs.add( new Song("One Day In Your Life", 4.17));
        songs.add( new Song("Music And Me", 2.37));
        songs.add( new Song("We're Almost There", 3.44));
        songs.add(new Song("I Wanna Be Where You Are", 2.58));
        songs.add(new Song("With A Child's Heart", 3.33));
        songs.add(new Song("My Girl", 3.08));
        songs.add(new Song("Happy (Love Theme From 'Lady Sings The Blues')", 3.26));
        songs.add(new Song("People Make The World Go Round", 3.14));
        songs.add(new Song("Maria (You Were The Only One)", 3.42));
        songs.add(new Song("Just A Little Bit Of You", 3.13));
        songs.add(new Song("Dapper Dan", 3.09));
        songs.add(new Song("Wings Of My Love", 3.19));
        songs.add(new Song("We've Got A Good Thing Going", 3.03));
        songs.add(new Song("In Our Small Way", 3.39));
        songs.add(new Song("Ain't No Sunshine", 4.11));
        songs.add(new Song("You've Got A Friend", 4.54));

        albums.add( new Album("Michael Jackson - The Motown Collection", "Pop", 2012, songs));

        songs = new ArrayList<>();
        songs.add(new Song("Bad", 4.08));
        songs.add(new Song ("Black Or White", 4.17));
        songs.add(new Song("Cheater", 5.09));
        songs.add(new Song("Dangerous", 6.40));
        songs.add( new Song("Dirty Diana", 4.41));
        songs.add( new Song("I Just Can't Stop Loving You", 4.13));
        songs.add( new Song("Jam", 5.40));
        songs.add( new Song("Man In The Mirror", 5.20));
        songs.add(new Song("Monkey Business", 5.45));
        songs.add(new Song("Remember The Time", 4.00));
        songs.add(new Song("Smooth Criminal", 4.18));
        songs.add( new Song("Someone Put Your Hand Out", 5.25));
        songs.add(new Song("The Way You Make Me Feel", 4.58));
        songs.add(new Song("Who Is It", 7.57));
        albums.add( new Album("The Ultimate Collection", "Pop", 2014, songs));

        return new Artist( "Michael Jackson", albums);

    }
}
