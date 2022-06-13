package bubble.joraku.game.unit;

import bubble.joraku.game.player.Color;

public class Samurai extends Unit {

    public Samurai(Color color) {
        super(color);
    }

    @Override
    public boolean isDaimyo() {
        return false;
    }
}
