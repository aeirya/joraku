package bubble.joraku.game.core;

import java.util.ArrayList;
import java.util.List;

import bubble.joraku.game.board.Board;
import bubble.joraku.game.player.Player;

public class GameState {
    private final List<Player> players;
    private final List<Integer> scores;
    private final Board board;

    public GameState() {
        players = new ArrayList<>();
        scores = new ArrayList<>();
        board = new Board();
    }

    public Board getBoard() {
        return board;
    }
}
