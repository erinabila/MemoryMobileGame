package com.erinabila.memorymobilegame;

import java.util.Hashtable;

public class GameModel {
    static int pointA = 0, pointB = 0,  round = 1;
    private String pair, pair2;
    private int row, column;
    private static Hashtable<String, Integer> answer = new Hashtable<>();
    private static Hashtable<String, Boolean> isFound = new Hashtable<>();

    public GameModel(String p, String p2, String r, String c) {
        this.pair = p;
        this.pair2 = p2;
        this.row = Integer.parseInt(r);
        this.column = Integer.parseInt(c);
    }

    public String scoreBoard() {
        String score = "ROUND " + round + ", it is ";

        if (round % 2 == 0) {
            score += "Player B Turn\n";
        } else {
            score += "Player A Turn\n";
        }
        //Player whom reaches a minimum of 10 points, wins
        if (pointA >= 10){
            score += "GAME OVER! Winner is Player A\n";
        } else if (pointB >= 10){
            score += "GAME OVER! Winner is Player B\n";
        }
        score += "PLAYER A: " + pointA  + " vs. PLAYER B: " + pointB;
        //if no match
        return score;
    }

    public Hashtable answerKey() {
        if (round == 1) {
            for (int i = 1; i <= row; i++) {
                for (int j = 1; j <= column; j++) {
                    String index = i + "," + j; //concatenate key
                    //set value range from 1 - 3
                    int value = (int) (3 * Math.random()) + 1;
                    answer.put(index, value);
                    isFound.put(index, false);
                }
            }
        }
        return answer;
    }

    public String playGame() {
        String str = "";
        answerKey();
        boolean found = false;

        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String key = i + "," + j;
                if (answer.get(pair).equals(answer.get(pair2))) {
                    isFound.put(pair, true);
                    isFound.put(pair2, true);
                    found = true;
                }

                if (key.equals(pair)) {
                    str += answer.get(pair);
                } else if (key.equals(pair2)) {
                    str += answer.get(pair2);
                } else {
                    str += "?";
                }
            }
            str += "\n";
        }
        if (found == true){
            if (round % 2 == 0) {
                pointB++;
            } else {
                pointA++;
            }
        }
        return str;
    }

    public String playNext() {
        String str = "";
        round++;
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= column; j++) {
                String key = i + "," + j;
                if (isFound.get(key)){ //works here!
                    str += answer.get(key);
                } else {
                    str += "?";
                }
            }
            str += "\n";
        }
        return str;
    }
}