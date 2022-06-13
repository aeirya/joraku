package bubble.joraku.gui.panel;

import java.awt.*;

import bubble.joraku.gui.interfaces.IController;

public class MainPanel extends Panel {
    public MainPanel(IController controller) {
        super(controller, null);

        setBackground(new Color(200, 200, 240));

        setLayout(new BorderLayout());
        add(new BoardPanel(controller, this), BorderLayout.CENTER);
        add(new AreaScorePanel(controller, this), BorderLayout.PAGE_END);
    }
}
