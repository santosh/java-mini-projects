public class Tweet {
    private String message;
    private User owner;
    private boolean isDeleted;

    private int tweetId;
    public static int counter = 0;

    public Tweet(String msg, User owner) {
        this.message = msg;
        this.owner = owner;
        this.isDeleted = false;

        this.tweetId = counter;
        counter++;
    }
}
