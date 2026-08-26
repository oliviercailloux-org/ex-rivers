package io.github.oliviercailloux.exercices.rivers.waterways;

import io.github.oliviercailloux.exercices.rivers.segments.Segment;
import io.github.oliviercailloux.exercices.rivers.segments.StraightSegment;
import java.util.List;

/**
 * Represents a river with a name and a list of segments. A segment is a geographically contiguous
 * part of the river, for example the part between the source and the first tributary, or between
 * two tributaries. The length of the river is the sum of the lengths of its segments.
 */
public class River {
  public River(String name) {

  }

  public String name() {

  }

  /**
   * Returns the segments of this river. The returned list is extended when
   * {@link #addSegment(Segment)} is called.
   */
  public List<Segment> segments() {

  }

  /**
   * Returns the segments of this river at the time of the call. The returned list is not modified
   * when {@link #addSegment(Segment)} is called.
   */
  public List<Segment> immutableSegments() {

  }

  public double length() {

  }

  /**
   * Adds a segment to this river.
   */
  public void addSegment(Segment segment) {

  }

  /**
   * Adds a straight segment to this river. Equivalent to calling {@link #addSegment(Segment)} with
   * a {@link StraightSegment} of the given length.
   */
  public void addStraightSegment(double length) {

  }
}
