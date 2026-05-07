package com.quickrelease.model;

/**
 * Represents a user in the Quick Release system.
 * Users can register, log in, and join tournaments or leagues.
 */
public class User {

    private int id;
    private String username;
    private String password;

    /**
     * Creates a new User instance.
     *
     * @param id unique user ID
     * @param username username for login
     * @param password user password
     */
    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    /**
     * Gets the user ID.
     *
     * @return user ID
     */
    public int getId() {
        return id;
    }

    /**
     * Gets the username.
     *
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the password.
     * (In real systems this would be encrypted, but kept simple for coursework.)
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }
}