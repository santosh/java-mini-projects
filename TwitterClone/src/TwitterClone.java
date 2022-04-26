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

    private User getUser(String username) {
        for (User u : allUsers) {
            if (Objects.equals(u.userName, username)) {
                return u;
            }
        }
        return null;
    }
}