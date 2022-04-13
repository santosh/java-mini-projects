package entities;

import java.util.ArrayList;
import java.util.List;

public class Artist {
    private int artistId;
    private String firstName;
    private String lastName;
    private List<Song> releasedSongs;
    private static int counter = 1;

    public Artist(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.artistId = counter;
        counter++;
        releasedSongs = new ArrayList<>();
    }

    public int getArtistId() {
        return artistId;
    }

    public String getName() {
        return firstName + " " + lastName;
    }

    public List<Song> getReleasedSongs() {
        return releasedSongs;
    }

    public void releaseSong(Song song) {
        releasedSongs.add(song);
    }
}
