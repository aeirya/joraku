package bubble.joraku.gui;

import bubble.joraku.game.core.GameState;
import bubble.joraku.gui.interfaces.IController;
import bubble.joraku.gui.interfaces.Updatable;

public class Controller implements IController, Updatable<GameState> {
    private Updatable<GameState> gui;
    
    public void setGui(Updatable<GameState> gui) {
        this.gui = gui;
    }

    @Override
    public void update(GameState state) {
        if (gui != null) gui.update(state);        
    }
}
