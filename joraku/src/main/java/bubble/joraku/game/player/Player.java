package bubble.joraku.game.player;

import java.util.ArrayList;
import java.util.List;

import bubble.joraku.game.card.Card;

public abstract class Player {
    private final List<Card> hand;

    public Player() {
        hand = new ArrayList<>();
    }

    protected List<Card> getHand() {
        return hand;
    }

    public abstract Card play();
}
