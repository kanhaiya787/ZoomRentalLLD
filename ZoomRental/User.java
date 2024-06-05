package ZoomRental;

public class User {
    int uid;
    String License;
    String userName;

    public User(int uid, String license, String userName) {
        this.uid = uid;
        License = license;
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
