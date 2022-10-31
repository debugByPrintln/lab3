package com.itmo.lab3;

import java.util.LinkedList;
import java.util.List;

public class WinnersList {
    private static final List<String> winners = new LinkedList<>();

    public static String getWinnersList() {
        String winnersList = "";
        if (winners.size() == 0){
            return "No winners yet";
        }
        for (String s: winners) {
            winnersList += s + "\n";
        }
        return winnersList;
    }

    public static void addNewWinner(String w){
        if (winners.size() >= 5){
            winners.remove(winners.size() - 1);
        }
        winners.add(0, w);
    }
}
