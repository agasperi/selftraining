package com.aega.training.idea.tdd;

public class MoodAnalyser {
    public String analyserMood(String message) {
        if(message.contains("sad")){
            return "SAD";
        }
        else{
            return "HAPPY";
        }
    }
}
