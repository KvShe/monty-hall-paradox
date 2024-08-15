package org.example.models;

import lombok.Getter;
import org.example.enums.Prize;

import java.util.Random;

public class Board {
    public final int AMOUNT_PRIZES = 3;
    @Getter
    private final Prize[] PRIZES = new Prize[AMOUNT_PRIZES];
    @Getter
    private int indexCar;

    public void fillPrizes() {
        Random random = new Random();
        indexCar = random.nextInt(PRIZES.length);
        PRIZES[indexCar] = Prize.CAR;

        for (int i = 0; i < PRIZES.length; i++) {
            PRIZES[i] = i == indexCar ? Prize.CAR : Prize.GOAT;
        }
    }

    public void showBoard() {
        for (Prize prize : PRIZES) {
            System.out.println(prize);
        }
    }
}
