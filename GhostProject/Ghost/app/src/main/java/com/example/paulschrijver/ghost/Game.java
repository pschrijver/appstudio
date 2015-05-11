package com.example.paulschrijver.ghost;


public class Game {

    public void guess(letterinput){
        filter(letterinput);
    }

    public void turn(player){
        if (player == currentplayer) {
            return true;
        }
        else {
            return false;
        }

    }

    public void ended(){
        if (finalWord  != ""){
            return true;
        }
        else {
            return false;
        }
    }

    public void winner(){
        String winner;
        if (ended() == true){
            winner = currentplayer;
            return winner;
        }
    }

}
