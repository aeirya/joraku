package bubble.joraku.gui.panel;

import java.awt.*;

import bubble.joraku.game.core.GameState;
import bubble.joraku.gui.interfaces.IController;

public class BoardPanel extends Panel {
    private static final int N_AREAS = 7;
    
    BoardPanel(IController controller, Panel parent) {
        super(controller, parent);

        setBackground(new Color(200, 160, 180));
        setLayout(new GridLayout(1, N_AREAS));

        initAreaPanels();
    }

    private void initAreaPanels() {
        for (int i=0; i<6; ++i) {
            add(new AreaPanel(getController(), this, i));
        }
    }

    @Override
    public void update(GameState state) {
        super.update(state);
    }
}
