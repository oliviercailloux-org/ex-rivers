package io.github.oliviercailloux.exercices.rivers.questions;

import io.github.oliviercailloux.exercices.rivers.waterways.Basin;
import io.github.oliviercailloux.exercices.rivers.waterways.River;
import java.util.Map;
import java.util.Set;

public class QuestionsByBasin implements Questions<String> {
  public QuestionsByBasin(Set<Basin> basins, Map<String, String> answersByBasin) {

  }

  /**
   * Sets the prompt template to use for these questions. The given string will be formatted with
   * the river name to produce the prompt for each question.
   */
  public void setPrompt(String promptTemplate) {

  }

  /** The prompt must have been set (and be non empty). */
  @Override
  public String questionString(River about) {

  }
}
