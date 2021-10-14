package com.aega.training.idea.tdd;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyserTest {
    @Test
    public void testMoodAnalysis() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyserMood("This is a sad message");
        Assert.assertThat(mood,CoreMatchers.is("SAD"));
    }

    @Test
    public void happytestMood() {
        MoodAnalyser moodAnalyser = new MoodAnalyser();
        String mood = moodAnalyser.analyserMood("This is a happy message");
        Assert.assertThat(mood,CoreMatchers.is("HAPPY"));
    }
}
