package bubble.joraku.game.unit;

import bubble.joraku.game.player.Color;

public abstract class Unit {

    private final Color color;

    protected Unit(Color color) {
        this.color = color;
    }

    public abstract boolean isDaimyo();
    
    public boolean isSamurai() {
        return !isDaimyo();
    }

    public Color getColor() {
        return color;
    }
}
