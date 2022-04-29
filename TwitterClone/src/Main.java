import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TwitterClone app = new TwitterClone();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to Twitter!");

        int option;

        do {
            System.out.println("Please choose your option: ");
            System.out.println("1. Create a new user");
            System.out.println("2. Post a tweet");
            System.out.println("3. Go to home page");
            System.out.println("4. Request to follow a user");
            System.out.println("5. Delete a tweet");
            System.out.println("Or press anything else to quit...");

            option = sc.nextInt();
            String username;
            String msg;

            switch (option) {
                case 1:
                    System.out.print("Please enter a username of your choice: ");
                    username = sc.nextLine();
                    app.createNewUser(username);
                    break;
                case 2:
                    System.out.print("Please enter a username: ");
                    username = sc.nextLine();
                    System.out.print("Please enter the tweet: ");
                    msg = sc.nextLine();
                    app.postTweet(username, msg);
                case 3:
                    System.out.print("Please enter a username: ");
                    username = sc.nextLine();
                    app.getHomepage(username);
                case 4:
                    System.out.print("Please enter your username: ");
                    username = sc.nextLine();
                    System.out.print("Please enter whom you want to follow: ");
                    String toBeFollowed = sc.nextLine();
                    app.followUser(username, toBeFollowed);
                case 5:
                    System.out.print("Please enter a tweetId: ");
                    int tweetIdToDelete = sc.nextInt();
                    System.out.print("Please enter your username: ");
                    username = sc.nextLine();
                    app.deleteTweet(tweetIdToDelete, username);
                default:
                    System.out.println("Thank you for using TwitterCLone");
            }
        } while (option >= 1 && option < 9);
    }
}
