package Factory;

import Utilities.Configuration;

import java.util.Random;

public abstract class Factory {
    protected final Random random = new Random();

    public int generateCoins() {
        return random.nextInt(Configuration.baseMaxGoldFight * Configuration.multiplier) + 1;
    }
}
