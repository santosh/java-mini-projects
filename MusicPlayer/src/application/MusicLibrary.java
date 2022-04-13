package application;

import entities.Artist;
import entities.Song;
import entities.User;

import java.net.UnknownServiceException;
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

    private List<Map.Entry<Integer, Integer>> getTopNByValue(Map<Integer, Integer> map, int n) {
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue() - o1.getValue();
            }
        });
        return list.subList(0, Math.min(n, list.size()));
    }

    public void getTop10Songs() {
        List<Map.Entry<Integer, Integer>> top10Songs = getTopNByValue(songPlayCounts, 10);

        for (int i = 0; i < top10Songs.size(); i++) {
            System.out.println("Song : " + songs.get(top10Songs.get(i).getKey()).getTitle() + ", played: " +
                    top10Songs.get(i).getValue() + " times");
        }
    }

    public void getTop10SongsForUser(int userId) throws Exception {
        if (!users.containsKey(userId)) {
            throw new Exception("User is invalid");
        }
        Map<Integer, Integer> usersSongs = userPlayHistory.get(userId);

        List<Map.Entry<Integer, Integer>> top10Songs = getTopNByValue(usersSongs, 10);

        for (int i = 0; i < top10Songs.size(); i++) {
            System.out.println("Song : " + songs.get(top10Songs.get(i).getKey()).getTitle() + ", played: " +
                    top10Songs.get(i).getValue() + " times");
        }
    }

    public void getSongsByArtist(int artistId) throws Exception {
        if (!artists.containsKey(artistId)) {
            throw new Exception("Artist is invalid");
        }

        List<Song> artistSongs = artists.get(artistId).getReleasedSongs();

        for (int i = 0; i < artistSongs.size(); i++) {
            System.out.println(artistSongs.get(i).getTitle());
        }
    }

    public void printAllArtists() {
        Set<Integer> artistIds = artists.keySet();

        for (Integer artistId: artistIds) {
            System.out.println(artistId + ": " + artists.get(artistId).getName());
        }
    }

    public User registerUser(String firstName, String lastName, String email, String phone,
                             String city, String locality, String state, int pinCode) {
        User newUser = new User(firstName, lastName, new User.Contact(email, phone), new User.Address(city, locality, state, pinCode));
        users.put(newUser.getUserId(), newUser);
        return newUser;
    }

    public Artist registerArtist(String firstName, String lastName) {
        Artist newArtist = new Artist(firstName, lastName);
        artists.put(newArtist.getArtistId(), newArtist);
        return newArtist;
    }

    public void addSong(int artistId, String title, String genre, int releaseYear, String language) throws Exception {
        if (!artists.containsKey(artistId)) {
            throw new Exception("Artist does not exist");
        }

        Song newSong = new Song(artistId, title, genre, releaseYear, language);
        songs.put(newSong.getSongId(), newSong);
        artists.get(artistId).releaseSong(newSong);
    }
}
