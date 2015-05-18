package com.example.paulschrijver.ghost;

import java.util.ArrayList;
import java.lang.String;

public class Dictionary {
    final String[] words = {"test", "android"};
    public String wordfilter;
    public String finalWord = "";

    public ArrayList<String> filterlist = new ArrayList<String>();


    public void filter(String wordinput) {


        if (filterlist.size() > 0) {
            for (String word : filterlist) {
                ArrayList<String> templist = new ArrayList<String>();
                if (word.matches(wordinput + "(.*)")) {
                    templist.add(word);
                }
                filterlist = templist;
            }
        }

        else {
            for (String word : words) {
                if (word.matches(wordinput + "(.*)")) {
                    filterlist.add(word);

                }
            }
        }
    }

    public void count(ArrayList<String> filterlist) {
        int wordamount = filterlist.size();
        return wordamount;
    }

    public void result() {
        int wordamount = count(filterlist);
        if (wordamount == 1) {
            String finalWord = filterlist.get(0);
            return finalWord;
        }
    }

    public void reset() {
        filter("");
    }


}

public class Game extends Dictionary {

    public void guess(){
        filter(wordinput);
}

    public void turn(){
        //Sharedprefs opzoeken
    }

    public void ended() {
        result();
        if (finalWord != ""){
            return true;
        }
        else {
            return false;
        }

    }

    public void winner() {
        boolean end = ended();
        if (end == true){
            //Sharedprefs opzoeken
        }


    }



}