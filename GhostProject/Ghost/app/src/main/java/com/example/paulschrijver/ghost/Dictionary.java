package com.example.paulschrijver.ghost;

public class Dictionary {
    final String[] words = {"test", "android"};

    public void filter(String wordinput){
        String[] filteredwords[];
        for (String word : words) {
            if (word.matches(wordinput + "(.*)")) {
                filteredwords[].add(word);
            }
        }
        count(filteredwords);
    }

    public void count(filteredwords) {
        int wordCount = filteredwords.size();
        if (wourdCount == 1) {
            result();
        }
        else {
            return wordCount;
        }
    }

    public void result() {
        finalWord = filteredwords.get(0);
        return finalWord;
    }

    public reset() {
        filter("");
    }



}
