package bubble.joraku.game.board;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import bubble.joraku.game.player.Color;
import bubble.joraku.game.unit.Unit;

public class Board {
    private final List<Area> areas;
    private final EnumMap<Color, Integer> daimyuLocations;
    private boolean isLocked = false;

    public Board() {
        areas = new ArrayList<>();
        daimyuLocations = new EnumMap<>(Color.class);
    }

    public void addDaimyu(int area, Color color) {
        unlock();
        if (daimyuLocations.containsKey(color)) return;
        daimyuLocations.put(color, area);
        areas.get(area).dropDaimyu(color);
    }

    public boolean attack(int area, Color attacker, Color attacked) {
        unlock();
        return areas.get(area).attack(attacker, attacked);
    }

    public void drop(int area, Color player) {
        unlock();
        areas.get(area).drop(player);
    }

    public List<List<Unit>> getUnits() {
        lock();
        return areas.stream().map(Area::getUnits).collect(Collectors.toList());
    }

    public Area getArea(int i) {
        lock();
        return areas.get(i);
    }

    public List<Area> getAreas() {
        lock();
        return areas;
    }

    /**
     * lock utility ensures all those who receive objects for viewing purposes don't accidentally edit them
     */
    private void unlock() {
        isLocked = false;
    }

    private void lock() {
        isLocked = true;
    }

    public boolean isLocked() {
        return isLocked;
    }
}
