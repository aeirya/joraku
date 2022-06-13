package bubble.joraku.gui.panel;

import java.awt.*;

import bubble.joraku.gui.interfaces.IController;

public class AreaScorePanel extends Panel {

    protected AreaScorePanel(IController controller, Panel parent) {
        super(controller, parent);
        setBackground(new Color(240, 240, 200));
        setPreferredSize(new Dimension(1, 300));
    }
    
}
