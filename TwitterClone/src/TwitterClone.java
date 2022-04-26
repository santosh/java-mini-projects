import java.util.Objects;

public class TwitterClone {
    private User[] allUsers;
    private Tweet[] allTweets;

    private int maxUserId;
    private int maxTweetId;

    public TwitterClone() {
        this.allTweets = new Tweet[1000];
        this.allUsers = new User[1000];

        this.maxUserId = -1;
        this.maxTweetId = -1;
    }

    public void createNewUser(String userName) {
        /*
        TODO: Assign a unique id
        TODO: Check if limits have exceeded
        TODO: Check if userID already exists
        TODO: Create a new User object
        TODO: Add to allUsers array
         */
        if (maxUserId == 999) {
            System.out.println("Sorry, limit exceeded. Can't onboard a new user now..");
        } else if (userName.equals("")) {
            System.out.println("userName cannot be blank!");
        } else if (getUser(userName) != null) {
            System.out.println("This user already exists!");
        } else {
            maxUserId++;
            User user = new User(maxUserId, userName);
            allUsers[maxUserId] = user;
        }
    }

    public void postTweet(String username, String tweet) {
        /*
        1. name validation
        2. limits of tweet
        3. msg validation
        4. handle tweetId
        5. create tweet object
        6. add to allTweets
        7. Add to myTweets of User
         */
        if (maxTweetId == 999) {
            System.out.println("Sorry, limit exceeded. Can't post a new tweet now..");
        } else if (tweet.equals("")) {
            System.out.println("Tweet is blank.");
        } else {
            User owner = getUser(username);
            if (owner == null) {
                System.out.println("User not found");
            } else {
                // Register tweet
                maxTweetId++;
                Tweet t = new Tweet(maxTweetId, tweet, owner);
                allTweets[maxTweetId] = t;

                for (int i = 0; i < 499; i++) {
                    if (owner.myTweets[i] == null) {
                        owner.myTweets[i] = t;
                        break;
                    }
                }
            }
        }
    }

    private User getUser(String username) {
        for (User u : allUsers) {
            if (Objects.equals(u.userName, username)) {
                return u;
            }
        }
        return null;
    }
}