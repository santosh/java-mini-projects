public class User {
    int userId;
    String userName;

    User[] following;
    User[] followers;
    User[] followReqs;

    Tweet[] myTweets;
    Tweet[] hiddenTweets;


    public User(int id, String username) {
        this.userId = id;
        this.userName = username;

        this.followers = new User[100];
        this.following = new User[100];
        this.followReqs = new User[100];

        this.myTweets = new Tweet[500];
        this.hiddenTweets = new Tweet[500];
    }

    public void addTweet(Tweet t) {

    }
}
