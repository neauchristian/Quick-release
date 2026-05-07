package com.quickrelease.service;

import com.quickrelease.model.League;
import com.quickrelease.model.OilPattern;

import java.time.LocalDateTime;
import java.util.*;

/**
 * Manages league creation and retrieval.
 * Supports sorting by difficulty.
 */
public class LeagueService {

    private final List<League> leagues = new ArrayList<>();

    /**
     * Creates a new league.
     *
     * @param name league name
     * @param bowlingCenter location
     * @param eventTime time of league
     * @param oilPattern lane conditions
     * @return created League
     */
    public League createLeague(String name,
                               String bowlingCenter,
                               LocalDateTime eventTime,
                               OilPattern oilPattern) {

        League league = new League(
                name,
                bowlingCenter,
                eventTime,
                oilPattern
        );

        leagues.add(league);
        return league;
    }

    /**
     * Returns all leagues.
     *
     * @return list of leagues
     */
    public List<League> getAllLeagues() {
        return leagues;
    }

    /**
     * Returns leagues sorted by difficulty (oil ratio).
     *
     * @return sorted list of leagues
     */
    public List<League> getLeaguesSorted() {

        List<League> sorted = new ArrayList<>(leagues);
        sorted.sort(null);
        return sorted;
    }
}