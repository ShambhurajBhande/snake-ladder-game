package com.snl.service;

import java.util.Random;

public class NormalDice implements Dice {
    @Override
    public int rollDice() {
        return 1+new Random().nextInt(6);
    }
}
