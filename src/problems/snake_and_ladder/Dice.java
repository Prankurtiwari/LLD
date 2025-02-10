package problems.snake_and_ladder;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    private final int count;
    private final int min;

    private final int max;

    public Dice(int count, int min, int max) {
        this.count = count;
        this.min = min;
        this.max = max;
    }

    public int rollDice() {
        int totalSum = 0;
        int diceUsed =0;

        while(diceUsed <count) {
            totalSum += ThreadLocalRandom.current().nextInt(min, max+1);
            diceUsed++;
        }
        return totalSum;
    }
}
