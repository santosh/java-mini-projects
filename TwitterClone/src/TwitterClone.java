import java.util.Objects;

public class TwitterClone {
    private User[] allUsers;
    private Tweet[] allTweets;

    private int maxUserId = 0;

    public TwitterClone() {

    }

    public void createNewUser(String userName) {
//        TODO: Check if userID already exists
//        TODO: Create a new User
//        TODO: Add to allUsers array
        if (userName.equals("")) {
            System.out.println("userName cannot be blank!");
        } else if (getUser(userName) != null) {
            System.out.println("This user already exists!");
        } else {
            User user = new User(userName);
            allUsers[maxUserId] = user;
            maxUserId++;

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