package application;

import java.util.Scanner;

public class Driver {
    private static MusicLibrary app = new MusicLibrary();

    public static void registerUsers(Scanner sc) {
        System.out.println("-----------------User Registration------------------");
        String addAgain;

        do {
            try {
                System.out.println("Enter user details");
                System.out.println("First Name: ");
                String firstName = sc.next();
                System.out.println("Last Name: ");
                String lastName = sc.next();
                System.out.println("Email: ");
                String email = sc.next();
                System.out.println("Phone: ");
                String phone = sc.next();
                System.out.println("City: ");
                String city = sc.next();
                System.out.println("Locality: ");
                String locality = sc.next();
                System.out.println("State: ");
                String state = sc.next();
                System.out.println("Pincode: ");
                int pincode = sc.nextInt();

                app.registerUser(firstName, lastName, email, phone, city, locality, state, pincode);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Would you like to add more users? (Y/n)");
            addAgain = sc.next();

        } while (addAgain.equals("Y"));
    }

    public static void registerArtists(Scanner sc) {
        System.out.println("-----------------Artist Registration------------------");
        String addAgain;

        do {
            try {
                System.out.println("Enter artist details");
                System.out.println("First Name: ");
                String firstName = sc.next();
                System.out.println("Last Name: ");
                String lastName = sc.next();

                app.registerArtist(firstName, lastName);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Would you like to add more artists? (Y/n)");
            addAgain = sc.next();
        } while (addAgain.equals("Y"));
    }

    public static void releaseSongs(Scanner sc) {
        System.out.println("-----------------Release Songs------------------");
        String addAgain;

        do {
            try {
                System.out.println("Enter song details");
                System.out.println("Title: ");
                String title = sc.next();
                System.out.println("Genre: ");
                String genre = sc.next();
                System.out.println("Release year: ");
                int releaseYear = sc.nextInt();
                System.out.println("Language: ");
                String language = sc.next();

                System.out.println("Please select artist from below:");
                app.printAllArtists();
                int artistId = sc.nextInt();
                app.addSong(artistId, title, genre, releaseYear, language);

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Would you like to release more songs? (Y/n)");
            addAgain = sc.next();
        } while (addAgain.equals("Y"));
    }

    public static void main(String... args) {
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter(System.lineSeparator());

        registerUsers(sc);
        registerArtists(sc);
        releaseSongs(sc);

        String addAgain;
        int userId, artistId, songId;

        do {
            try {
                System.out.println("Please choose option from below" +
                        "\n1. Play a song" +
                        "\n2. Get top 10 songs overall" +
                        "\n3. Get top 10 songs for a user" +
                        "\n4. Get all songs of an artist");
                System.out.println("Enter choice: ");
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        // userId and songId is required
                        try {
                            System.out.println("Please enter userId: ");
                            userId = sc.nextInt();
                            System.out.println("Please enter songId: ");
                            songId = sc.nextInt();
                            app.playSong(songId, userId);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 2:
                        // nothing is required
                        app.getTop10Songs();
                        break;
                    case 3:
                        // userId is required
                        try {
                            System.out.println("Please enter userId: ");
                            userId = sc.nextInt();
                            app.getTop10SongsForUser(userId);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 4:
                        // artistId is required
                        try {
                            System.out.println("Please select an artist (enter number only): ");
                            app.printAllArtists();
                            System.out.println("Please enter artistId");
                            artistId = sc.nextInt();
                            app.getSongsByArtist(artistId);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        break;
                    case 5:
                        System.out.println("invalid choice");
                        break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            System.out.println("Would you like one more operation? (Y/n)");
            addAgain = sc.next();
        } while (addAgain.equals("Y"));
    }
}
