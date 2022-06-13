package bubble.joraku.game.board;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import bubble.joraku.game.player.Color;
import bubble.joraku.game.unit.Daimyo;
import bubble.joraku.game.unit.Unit;

/**
 * units of the same color in an area
 */
public class Troop {
    private final List<Unit> units;
    private final Color color;
    private final TokenPool tokenPool;

    public Troop(Color color, TokenPool tokenPool) {
        this.color = color;
        this.tokenPool = tokenPool;
        units = new ArrayList<>();
    }

    public void drop() {
        units.addAll(
            tokenPool.popThree(color)
        );
    }

    public void dropDaimyu() {
        units.add(new Daimyo(color));
    }

    /** 
     * kills a samurai off the troop and returns it to the token poll 
     * @return true if arena contains samurais
     * */
    public boolean killUnit() {
        Optional<Unit> unit = units.stream()
            .filter(Unit::isSamurai)
            .findFirst();

        unit.ifPresent(u -> {
            units.remove(u);
            tokenPool.add(color, u);
        });

        return unit.isPresent();
    }

    public boolean hasDaimyo() {
        return units.stream().anyMatch(Unit::isDaimyo);
    }

    public int getStrengh() {
        return units.size() + (hasDaimyo() ? 1:0);
    }

    /** 
     * warning: only used for the gui
     * todo: replace this
     */
    public List<Unit> getUnits() {
        return units;
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return units.size();
    }
}
