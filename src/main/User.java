package main;


import java.util.prefs.Preferences;

public class User {
    private String username;

    public User(String username, String id) {
        this.username = username;
        this.id = id;
    }

    private String id;

    public String getUsername() {
        return username;
    }

    public String getId() {
        return id;
    }
}
