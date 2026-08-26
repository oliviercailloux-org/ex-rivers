package io.github.oliviercailloux.exercices.rivers.questions;

import io.github.oliviercailloux.exercices.rivers.waterways.River;
import java.util.Iterator;

public interface Questions<V> {
  public Iterator<River> rivers();

  public String questionString(River about);

  public V answer(River r);
}
