package com.quickrelease.model;

/**
 * Represents a bowling tournament in the Quick Release system.
 * Each tournament has a name, location, time, and oil pattern conditions.
 * Tournaments are comparable based on oil pattern difficulty.
 */
public class Tournament implements Comparable<Tournament> {

    private String name;
    private String bowlingCenter;
    private java.time.LocalDateTime eventTime;
    private OilPattern oilPattern;

    /**
     * Creates a new Tournament instance.
     *
     * @param name tournament name
     * @param bowlingCenter location of tournament
     * @param eventTime scheduled date and time
     * @param oilPattern lane conditions affecting difficulty
     */
    public Tournament(String name,
                      String bowlingCenter,
                      java.time.LocalDateTime eventTime,
                      OilPattern oilPattern) {

        this.name = name;
        this.bowlingCenter = bowlingCenter;
        this.eventTime = eventTime;
        this.oilPattern = oilPattern;
    }

    /**
     * Gets the tournament name.
     *
     * @return tournament name
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
     * Gets the scheduled event time.
     *
     * @return event time
     */
    public java.time.LocalDateTime getEventTime() {
        return eventTime;
    }

    /**
     * Gets the oil pattern used in this tournament.
     *
     * @return oil pattern
     */
    public OilPattern getOilPattern() {
        return oilPattern;
    }

    /**
     * Compares tournaments based on oil pattern ratio.
     * Lower ratio = more difficult conditions.
     *
     * @param other another tournament
     * @return comparison result for sorting
     */
    @Override
    public int compareTo(Tournament other) {
        return Double.compare(
                this.oilPattern.getRatio(),
                other.oilPattern.getRatio()
        );
    }
}