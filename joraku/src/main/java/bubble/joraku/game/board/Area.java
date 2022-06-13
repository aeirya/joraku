package bubble.joraku.game.board;

import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import bubble.joraku.game.player.Color;
import bubble.joraku.game.unit.Unit;

public class Area {
    private final EnumMap<Color, Troop> areaUnits;
    private final TokenPool tokenPool;

    public Area(TokenPool tokenPool) {
        this.tokenPool = tokenPool;
        areaUnits = new EnumMap<>(Color.class);
    }

    public void drop(Color player) {
        getUnits(player).drop();
    }

    public void dropDaimyu(Color player) {
        getUnits(player).dropDaimyu();
    }

    /**
     * @return troops of a player in the area
     */
    private Troop getUnits(Color player) {
        return areaUnits.computeIfAbsent(player, color -> new Troop(color, tokenPool));
    }

    public boolean attack(Color attacker, Color attacked) {
        if (areaUnits.get(attacker).hasDaimyo()) {
            return areaUnits.get(attacked).killUnit();
        }
        return false;
    }

    public List<Unit> getUnits() {
        return areaUnits
            .values()
            .stream()
            .flatMap(t -> t.getUnits().stream())
            .collect(Collectors.toList());
    }

    public Color getStrongestPlayer() {
        return areaUnits
            .entrySet()
            .stream()
            .max(Comparator.comparing(e -> e.getValue().getStrengh()))
            .map(Entry::getKey)
            .orElse(null);
    }

    public Collection<Troop> getTroops() {
        return areaUnits.values();
    }
}
