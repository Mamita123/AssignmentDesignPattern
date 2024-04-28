package org.example;

/*public class User {
    private String username;

    public User(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }
}*/
// User class
public class CurrentUser {
    private String username;
    private static CurrentUser instance;

    private CurrentUser(String username) {
        this.username = username;
    }

    public static CurrentUser getInstance() {
        if (instance == null) {
            // Default user
            instance = new CurrentUser("guest");
        }
        return instance;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        getInstance().username= username;
    }
}