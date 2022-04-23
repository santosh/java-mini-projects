public class User {
    String userName;

    User[] following;
    User[] followers;
    User[] followReq;

    Tweet[] myTweets;
    Tweet[] hiddenTweets;

    private int userId;
    public static int counter = 0;

    public User(String username) {
        this.userName = username;

        this.followers = new User[100];
        this.following = new User[100];
        this.followReq = new User[100];

        this.myTweets = new Tweet[500];
        this.hiddenTweets = new Tweet[500];

        this.userId = counter;
        counter++;
    }
}
