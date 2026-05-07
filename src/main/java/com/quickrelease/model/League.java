package com.quickrelease.model;

/**
 * Represents a bowling league in the Quick Release system.
 * A league has a name, location, scheduled time, and oil pattern conditions.
 * Leagues are comparable based on oil pattern difficulty (ratio).
 */
public class League implements Comparable<League> {

    private String name;
    private String bowlingCenter;
    private java.time.LocalDateTime eventTime;
    private OilPattern oilPattern;

    /**
     * Creates a new League instance.
     *
     * @param name name of the league
     * @param bowlingCenter location of the league
     * @param eventTime scheduled date and time
     * @param oilPattern lane oil conditions
     */
    public League(String name,
                  String bowlingCenter,
                  java.time.LocalDateTime eventTime,
                  OilPattern oilPattern) {

        this.name = name;
        this.bowlingCenter = bowlingCenter;
        this.eventTime = eventTime;
        this.oilPattern = oilPattern;
    }

    /**
     * Gets the league name.
     *
     * @return league name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the bowling center location.
     *
     * @return bowling center
     */
    public String getBowlingCenter() {
        return bowlingCenter;
    }

    /**
     * Gets the oil pattern for this league.
     *
     * @return oil pattern
     */
    public OilPattern getOilPattern() {
        return oilPattern;
    }

    /**
     * Compares leagues based on oil pattern ratio.
     * Lower ratio = more difficult conditions.
     *
     * @param other another league
     * @return comparison result for sorting
     */
    @Override
    public int compareTo(League other) {
        return Double.compare(
                this.oilPattern.getRatio(),
                other.oilPattern.getRatio()
        );
    }
}