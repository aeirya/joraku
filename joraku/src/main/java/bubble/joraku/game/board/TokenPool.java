package bubble.joraku.game.board;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.stream.Collectors;

import bubble.joraku.game.player.Color;
import bubble.joraku.game.unit.Samurai;
import bubble.joraku.game.unit.Unit;

public class TokenPool {
    private final EnumMap<Color, List<Unit>> tokens;

    public TokenPool(List<Color> colors) {
        tokens = new EnumMap<>(Color.class);

        for (Color player : colors) {
            List<Unit> playerPool = tokens.put(player, new ArrayList<>());

            for (int i=0; i<10; ++i) {
                playerPool.add(new Samurai(player));
            }
        }
    }

    /**
     * pops at most three tokens (if available)
     */
    public List<Unit> popThree(Color player) {
        List<Unit> playerPool = tokens.get(player);
        List<Unit> chosen = playerPool.stream().limit(3).collect(Collectors.toList());
        for (Unit token : chosen) {
            playerPool.remove(token);
        }
        return chosen;
    }

    /**
     * returns back a token to the pool
     */
    public void add(Color player, Unit samurai) {
        tokens.get(player).add(samurai);
    }
}
