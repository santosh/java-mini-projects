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
        1. Assign a unique id
        2. Check if limits have exceeded
        3. Check if userID already exists
        4. Create a new User object
        5. Add to allUsers array
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
        for (int i = 0; i <= 999; i++) {
            if (allUsers[i] == null) {
                break;
            } else if (username.equals(allUsers[i].userName)) {
                return allUsers[i];
            }
        }
        return null;
    }

    private Tweet getTweet(int id) {
        for (int i = 0; i <= 999; i++) {
            if (allTweets[i] == null) {
                break;
            } else if (id == allTweets[i].getTweetId()) {
                return allTweets[i];
            }
        }
        return null;
    }

    public void getHomepage(String username) {
        User owner = getUser(username);
        if (owner == null) {
            System.out.println("User not found");
        } else {
            System.out.println("---------- Home Page -----------");
            for (Tweet t : owner.myTweets) {
                if (!t.isDeleted()) {
                    System.out.println(t.getTweetId() + ": " + t.getMessage());
                }
            }
            System.out.println("-------- End of Home Page ---------");
        }
    }

    public void followUser(String username, String toBeFollowed) {
        /*
        1. Verify if both name exist
        2. Verify if both name are not same
        3. Verify if follower limit has not reached
        4. Add to followReq array
        5.
         */
        User follower = getUser(username);
        User leader = getUser(toBeFollowed);

        if (username.equals(toBeFollowed)) {
            System.out.println("You can't follow yourself!");
        } else if (follower == null) {
            System.out.println("Username not valid or not exist");
        } else if (toBeFollowed == null) {
            System.out.println("Username not valid or not exist");
        } else {
            boolean isEmptySpace = false;
            for (int i = 0; i < 100; i++) {
                if (leader.followReqs[i] == null) {
                    isEmptySpace = true;
                    break;
                }
            }

            if (isEmptySpace == false) {
                System.out.println("Follow request limit reached.");
            } else {
                boolean isAlreadyRequested = false;
                for (int i = 0; i < 100; i++) {
                    if (leader.followReqs[i].userId == follower.userId) {
                        isAlreadyRequested = true;
                        break;
                    }
                }

                if (isAlreadyRequested == true) {
                    System.out.println("User already followed");
                } else {
                    for (int i = 0; i < 100; i++) {
                        if (leader.followReqs[i] == null) {
                            leader.followReqs[i] = follower;
                            break;
                        }
                    }
                }
            }
        }
    }

    public void deleteTweet(int tweetIdToDelete, String username) {
        User owner = getUser(username);
        Tweet tweet = getTweet(tweetIdToDelete);

        if (owner == null) {
            System.out.println("The user name is invalid");
        } else if (tweet == null) {
            System.out.println("The tweetId is invalid");
        } else if (tweet.isDeleted()) {
            System.out.println("The tweet is already deleted");
        } else if (tweet.getOwner().userId != owner.userId) {
            System.out.println("The user name is invalid");
        } else {
            tweet.setDeleted(true);
            System.out.println("This tweet is deleted...");
        }
    }
}