package com.quickrelease.model;

/**
 * Represents the oil pattern applied to a bowling lane.
 * Oil patterns affect lane difficulty through length, oil volume, and ratio.
 */
public class OilPattern {

    private String name;
    private int length; // in feet (32–60)
    private double oilVolume; // in milliliters
    private double ratio; // difficulty rating (e.g. 8.0 easy, 1.0 hard)

    /**
     * Creates a new OilPattern instance.
     *
     * @param name name of the oil pattern
     * @param length length of oil on lane (32–60 feet)
     * @param oilVolume amount of oil applied (ml)
     * @param ratio difficulty ratio (lower = harder conditions)
     */
    public OilPattern(String name,
                      int length,
                      double oilVolume,
                      double ratio) {

        this.name = name;
        this.length = length;
        this.oilVolume = oilVolume;
        this.ratio = ratio;
    }

    /**
     * Gets the name of the oil pattern.
     *
     * @return pattern name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the length of the oil pattern.
     *
     * @return length in feet
     */
    public int getLength() {
        return length;
    }

    /**
     * Gets the oil volume used on the lane.
     *
     * @return oil volume in milliliters
     */
    public double getOilVolume() {
        return oilVolume;
    }

    /**
     * Gets the difficulty ratio of the oil pattern.
     * Lower values indicate more difficult lane conditions.
     *
     * @return ratio value
     */
    public double getRatio() {
        return ratio;
    }
}