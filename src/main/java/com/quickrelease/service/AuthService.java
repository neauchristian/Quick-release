package com.quickrelease.service;

import com.quickrelease.model.User;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Service responsible for user authentication and account management.
 * Stores users in a Map for fast lookup by username.
 */
public class AuthService {

    private final Map<String, User> users = new HashMap<>();
    private User loggedInUser;

    /**
     * Registers a new user if the username does not already exist.
     *
     * @param username the desired username
     * @param password the user's password
     * @return true if registration is successful, false otherwise
     */
    public boolean register(String username, String password) {

        if (users.containsKey(username)) {
            return false;
        }

        User user = new User(users.size() + 1, username, password);
        users.put(username, user);

        return true;
    }

    /**
     * Logs in a user if credentials match.
     *
     * @param username the username
     * @param password the password
     * @return true if login is successful, false otherwise
     */
    public boolean login(String username, String password) {

        User user = users.get(username);

        if (user != null && user.getPassword().equals(password)) {
            loggedInUser = user;
            return true;
        }

        return false;
    }

    /**
     * Logs out the current user.
     */
    public void logout() {
        loggedInUser = null;
    }

    /**
     * Returns the currently logged-in user.
     *
     * @return logged-in user or null if none
     */
    public User getLoggedInUser() {
        return loggedInUser;
    }

    /**
     * Returns all registered users.
     *
     * @return collection of users
     */
    public Collection<User> getAllUsers() {
        return users.values();
    }
}