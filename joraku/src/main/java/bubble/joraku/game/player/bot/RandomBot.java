package bubble.joraku.game.player.bot;

import java.util.Random;

import bubble.joraku.game.card.Card;

public class RandomBot extends Bot {
    private static final Random random = new Random();
    
    public Card play() {
        return getHand().remove(
            random.nextInt(getHand().size())
        );
    }
}
