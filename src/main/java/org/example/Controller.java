package org.example;

import java.util.HashMap;
import java.util.Map;

public class Controller {
    private Map<Integer, Boolean> mapPlayerDoesNotChangeHisChoice = new HashMap<>();
    private Map<Integer, Boolean> mapPlayerChangesHisChoice = new HashMap<>();

    public void run() {
        Game gameWithChange = new Game();
        for (int i = 0; i < 10000; i++) {
            mapPlayerDoesNotChangeHisChoice.put(i, gameWithChange.roundInWhichPlayerDoesNotChangeHisChoice());
        }

        Game gameUnchanged = new Game();
        for (int i = 0; i < 10000; i++) {
            mapPlayerChangesHisChoice.put(i, gameUnchanged.roundInWhichPlayerChangesHisChoice());
        }

        showCountWinnerTwoTests(gameWithChange, gameUnchanged);
    }

    private void showCountWinnerTwoTests(Game gameWithChange, Game gameUnchanged) {
        System.out.println("Player change your choice ->" + gameWithChange.getCountWinner());
        System.out.println("Player not change your choice ->" + gameUnchanged.getCountWinner());
    }
}
