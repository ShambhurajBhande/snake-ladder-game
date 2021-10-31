package com.snl.model;

import com.snl.service.Dice;
import java.util.Random;

public class NormalDiceMock implements Dice {
    @Override
    public int rollDice() {
        return 10;
    }
}
