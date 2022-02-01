package com.example.essensplaner.data.model;

/**
 * Data class that captures user information for logged in users retrieved from LoginRepository
 */
public class LoggedInUser {

    private String userId;
    private String displayName;
    private int group ;

    public LoggedInUser(String userId, String displayName, String group) {
        this.userId = userId;
        this.displayName = displayName;
        this.group = Integer.parseInt(group);
    }

    public int getGroup() {
        return group;
    }

    public String getUserId() {
        return userId;
    }

    public String getDisplayName() {
        return displayName;
    }
}