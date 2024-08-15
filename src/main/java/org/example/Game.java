package org.example;

import lombok.Getter;
import org.example.enums.Status;
import org.example.models.Board;
import org.example.models.Player;

import java.util.Random;

public class Game {
    private Board board = new Board();
    private Player player = new Player();
    private Player showHost = new Player();
    @Getter
    private int countWinner;


    public boolean roundInWhichPlayerChangesHisChoice() {
        initial();
        showHostOpenPrizeToGoat();

        playerChangeIndexPrize();

        return isWinner();
    }

    public boolean roundInWhichPlayerDoesNotChangeHisChoice() {
        initial();
        showHostOpenPrizeToGoat();

        return isWinner();
    }

    private void initial() {
        board.fillPrizes();
        showHost.setIndex(board.getIndexCar());
        playerSelectsIndexPrize();
    }

    private void playerSelectsIndexPrize() {
        Random random = new Random();
        player.setIndex(random.nextInt(board.AMOUNT_PRIZES));
    }

    /**
     * Show host open prize to goat
     */
    private void showHostOpenPrizeToGoat() {
        Random random = new Random();
        int index;

        do {
            index = random.nextInt(board.AMOUNT_PRIZES);
        } while (index != player.getIndex() && index != board.getIndexCar());

        board.getPRIZES()[index].setStatus(Status.OPEN);
    }

    /**
     * Player change your choice
     */
    private void playerChangeIndexPrize() {
        for (int i = 0; i < board.getPRIZES().length; i++) {
            if (i == player.getIndex()) continue;

            if (board.getPRIZES()[i].getStatus() == Status.CLOSED) {
                player.setIndex(i);
                break;
            }
        }
    }

    /**
     * @return test victory players
     */
    private boolean isWinner() {
//        return player.getIndex() == board.getIndexCar();
        if (player.getIndex() == board.getIndexCar()) {
            countWinner++;
            return true;
        }

        return false;
    }
}
