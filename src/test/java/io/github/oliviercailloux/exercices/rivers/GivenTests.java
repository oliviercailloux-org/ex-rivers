package io.github.oliviercailloux.exercices.rivers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import io.github.oliviercailloux.exercices.rivers.questions.LengthQuestions;
import io.github.oliviercailloux.exercices.rivers.questions.Questions;
import io.github.oliviercailloux.exercices.rivers.questions.QuestionsByBasin;
import io.github.oliviercailloux.exercices.rivers.questions.SingleRiverQuestion;
import io.github.oliviercailloux.exercices.rivers.waterways.Basin;
import io.github.oliviercailloux.exercices.rivers.waterways.River;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Test;

public class GivenTests {

  @Test
  void testRiversEquality() throws Exception {
    ImmutableSet.Builder<River> manyNilesBuilder = new ImmutableSet.Builder<>();
    for (int i = 0; i < 100; i++) {
      manyNilesBuilder.add(new River("Nile"));
    }

    ImmutableSet<River> oneNile = ImmutableSet.of(new River("Nile"));
    assertEquals(oneNile, manyNilesBuilder.build());
  }

  @Test
  void testLengthQuestions() throws Exception {
    River nile = new River("Nile");
    River amazon = new River("Amazon");
    River congo = new River("Congo");
    Questions<Integer> questions =
        new LengthQuestions(ImmutableMap.of(new River("Nile"), 6650, new River("Amazon"), 6400));
    assertEquals(ImmutableSet.of(nile, amazon), ImmutableSet.copyOf(questions.rivers()));
    assertEquals("What is the length in km of the Nile?", questions.questionString(nile));
    assertEquals(6650, questions.answer(nile));
    assertEquals("What is the length in km of the Amazon?", questions.questionString(amazon));
    assertEquals(6400, questions.answer(amazon));
    assertThrows(NoSuchElementException.class, () -> questions.questionString(congo));
  }

  @Test
  void testSingleRiverQuestion() throws Exception {
    River rhine = new River("Rhine");
    River rhone = new River("Rhone");
    Questions<River> questions =
        new SingleRiverQuestion(rhine, rhone, "Which river shares its source region with %s?");
    assertEquals(ImmutableSet.of(rhine), ImmutableSet.copyOf(questions.rivers()));
    assertEquals("Which river shares its source region with Rhine?",
        questions.questionString(rhine));
    assertEquals(rhone, questions.answer(rhine));
  }

  @Test
  void testQuestionsByBasin() throws Exception {
    River loire = new River("Loire");
    River garonne = new River("Garonne");
    River seine = new River("Seine");
    Basin atlantic = new Basin("Atlantic", ImmutableSet.of(loire, garonne, seine));

    River rhone = new River("Rhone");
    River var = new River("Var");
    River aude = new River("Aude");
    Basin mediterranean = new Basin("Mediterranean", ImmutableSet.of(rhone, var, aude));

    River rhine = new River("Rhine");
    River meuse = new River("Meuse");
    River scheldt = new River("Scheldt");
    Basin northSea = new Basin("North Sea", ImmutableSet.of(rhine, meuse, scheldt));

    ImmutableSet<Basin> basins = ImmutableSet.of(atlantic, mediterranean, northSea);
    ImmutableMap<String, String> answers = ImmutableMap.of("Atlantic", "Atlantic Ocean",
        "Mediterranean", "Mediterranean Sea", "North Sea", "North Sea");
    QuestionsByBasin questions = new QuestionsByBasin(basins, answers);
    questions.setPrompt("Into which body of water does %s flow?");

    ImmutableSet<River> allRivers = new ImmutableSet.Builder<River>()
        .add(loire, garonne, seine, rhone, var, aude, rhine, meuse, scheldt).build();
    assertEquals(allRivers, ImmutableSet.copyOf(questions.rivers()));

    assertEquals("Into which body of water does Garonne flow?", questions.questionString(garonne));
    assertEquals("Atlantic Ocean", questions.answer(garonne));
    assertEquals("Mediterranean Sea", questions.answer(rhone));
    assertEquals("Mediterranean Sea", questions.answer(var));
    assertEquals("North Sea", questions.answer(rhine));
    assertThrows(NoSuchElementException.class,
        () -> questions.questionString(new River("Danube")));
  }
}
