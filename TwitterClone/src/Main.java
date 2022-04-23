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
            System.out.println("Or press anything else to quit...");

            option = sc.nextInt();
            String username;

            switch (option) {
                case 1:
                    System.out.println("Please enter a username of your choice");
                    username = sc.nextLine();
                    app.createNewUser(username);
                    break;
                default:
                    System.out.println("Thank you for using TwitterCLone");
            }
        } while (option >= 1 && option < 9);
    }
}
