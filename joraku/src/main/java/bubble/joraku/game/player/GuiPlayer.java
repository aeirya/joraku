package bubble.joraku.game.player;

import java.util.concurrent.Semaphore;

import bubble.joraku.game.card.Card;

public class GuiPlayer extends Player {

    private final Semaphore lock;
    private Card playedCard;

    public GuiPlayer() {
        lock = new Semaphore(0);
    }

    @Override
    public Card play() {
        try {
            lock.acquire();
            return playedCard;
        } catch (InterruptedException e) {
            e.printStackTrace();
            Thread.currentThread().interrupt();
        }
        return null;
    }

    public void play(Card card) {
        this.playedCard = card;
        lock.drainPermits();
        lock.release();
    }
}
