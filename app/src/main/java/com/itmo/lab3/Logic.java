package com.itmo.lab3;

import java.util.LinkedList;
import java.util.List;

public class Logic {
    static List<String> winners = new LinkedList<>();

    public static String getWinnersList(){
        String res = "";
        if (winners.size() == 0){
            return "NO WINNERS YET";
        }
        else if(winners.size() <= 4){
            for (int i = winners.size()-1; i >= 0; i--) {
                res += winners.get(i) + "\n";
            }
        }
        else{
            for (int i = winners.size()-1; i >= winners.size()-5; i--){
                res += winners.get(i) + "\n";
            }
        }
        return res;
    }

    public static void addNewWinner(String w){
        winners.add(w);
    }
}
