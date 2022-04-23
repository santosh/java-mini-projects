public class User {
    int userId;
    String userName;

    User[] following;
    User[] followers;
    User[] followReq;

    Tweet[] myTweets;
    Tweet[] hiddenTweets;
}
