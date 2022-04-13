package application;

import entities.Artist;
import entities.Song;
import entities.User;

import java.util.*;

public class MusicLibrary {
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Song> songs = new HashMap<>();
    private Map<Integer, Artist> artists = new HashMap<>();
    private Map<Integer, Integer> songPlayCounts = new HashMap<>();
    private Map<Integer, Map<Integer, Integer>> userPlayHistory = new HashMap<>();

    public void playSong(int songId, int userId) throws Exception {
        if (!songs.containsKey(songId)) {
            throw new Exception("Invalid Song");
        }
        if (!users.containsKey(userId)) {
            throw new Exception("Invalid User");
        }

        Song song = songs.get(songId);
        User user = users.get(userId);
        song.markPlayed();

        System.out.println(user.getName() + " is listening to song : " + song.getTitle() +
                ", " + "sung by " + artists.get(song.getArtistId()).getName());

        Map<Integer, Integer> userSongPlayCount = userPlayHistory.get(userId);

        int currentUserSongCount = 0;
        if (userSongPlayCount != null) {
            currentUserSongCount = userSongPlayCount.getOrDefault(songId, 0);
        } else {
            userSongPlayCount = new HashMap<>();
        }
        currentUserSongCount++;

        userSongPlayCount.put(songId, currentUserSongCount);
        userPlayHistory.put(userId, userSongPlayCount);

        int totalSongCounts = 0;
        totalSongCounts = songPlayCounts.getOrDefault(songId, 0);
        songPlayCounts.put(songId, totalSongCounts+1);


        }

}
