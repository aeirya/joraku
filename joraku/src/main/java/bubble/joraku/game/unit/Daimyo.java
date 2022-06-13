package bubble.joraku.game.unit;

import bubble.joraku.game.player.Color;

public class Daimyo extends Unit {

    public Daimyo(Color color) {
        super(color);
    }

    @Override
    public boolean isDaimyo() {
        return true;
    }
    
}
