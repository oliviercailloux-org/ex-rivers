package io.github.oliviercailloux.exercices.rivers.segments;

public class MeanderingSegment implements Segment {
  /**
   * Creates a meandering segment with the given length, directly.
   */
  public MeanderingSegment(double length) {

  }

  /**
   * Creates a meandering segment from the straight-line distance between its two ends and its
   * sinuosity. The length of the segment equals the given distance multiplied by the given
   * sinuosity.
   *
   * @param straightLineDistance must be positive
   * @param sinuosity must be at least one, as a meandering path cannot be shorter than the
   *        straight-line distance between its ends
   * @throws IllegalArgumentException if {@code straightLineDistance} is not positive or
   *         {@code sinuosity} is less than one
   */
  public MeanderingSegment(double straightLineDistance, double sinuosity) {

  }
}
