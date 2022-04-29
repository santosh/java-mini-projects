public class Tweet {
    private int tweetId;
    private String message;
    private User owner;
    private boolean isDeleted;

    public Tweet(int id, String msg, User owner) {
        this.tweetId = id;
        this.message = msg;
        this.owner = owner;
        this.isDeleted = false;
    }

    public User getOwner() {
        return owner;
    }

    public String getMessage() {
        return message;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public int getTweetId() {
        return tweetId;
    }

    public boolean isDeleted() {
        return isDeleted;
    }
}
