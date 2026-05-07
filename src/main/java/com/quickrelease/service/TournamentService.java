package com.quickrelease.service;

import com.quickrelease.model.Tournament;
import com.quickrelease.model.User;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Handles tournament creation, waitlist management (Queue),
 * and action history tracking (Stack).
 */
public class TournamentService {

    private final List<Tournament> tournaments = new ArrayList<>();
    private final Queue<User> waitlist = new LinkedList<>();
    private final Stack<String> actionHistory = new Stack<>();

    /**
     * Creates a new tournament and stores it.
     *
     * @param name tournament name
     * @param bowlingCenter location
     * @param eventTime date and time
     * @param oilPattern lane conditions
     * @return created Tournament
     */
    public Tournament createTournament(String name,
                                       String bowlingCenter,
                                       LocalDateTime eventTime,
                                       com.quickrelease.model.OilPattern oilPattern) {

        Tournament tournament = new Tournament(
                name,
                bowlingCenter,
                eventTime,
                oilPattern
        );

        tournaments.add(tournament);
        actionHistory.push("Created tournament: " + name);

        return tournament;
    }

    /**
     * Returns all tournaments.
     *
     * @return list of tournaments
     */
    public List<Tournament> getAllTournaments() {
        return tournaments;
    }

    /**
     * Returns tournaments sorted by difficulty (oil ratio).
     *
     * @return sorted list of tournaments
     */
    public List<Tournament> getTournamentsSorted() {

        List<Tournament> sorted = new ArrayList<>(tournaments);
        sorted.sort(null);
        return sorted;
    }

    /**
     * Adds a user to the tournament waitlist (FIFO order).
     *
     * @param user user joining the queue
     */
    public void joinWaitlist(User user) {
        waitlist.add(user);
        actionHistory.push(user.getUsername() + " joined waitlist");
    }

    /**
     * Removes and returns the next user in the queue.
     *
     * @return next user or null if empty
     */
    public User serveNextUser() {
        return waitlist.poll();
    }

    /**
     * Returns the current waitlist.
     *
     * @return queue of users
     */
    public Queue<User> getWaitlist() {
        return waitlist;
    }

    /**
     * Returns action history stack.
     *
     * @return stack of actions
     */
    public Stack<String> getActionHistory() {
        return actionHistory;
    }

    /**
     * Undoes the last recorded action.
     *
     * @return removed action or null if empty
     */
    public String undoLastAction() {
        if (!actionHistory.isEmpty()) {
            return actionHistory.pop();
        }
        return null;
    }
}