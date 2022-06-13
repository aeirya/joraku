package bubble.joraku.gui;

import javax.swing.JFrame;

import bubble.joraku.game.core.GameState;
import bubble.joraku.gui.interfaces.IController;
import bubble.joraku.gui.interfaces.Updatable;
import bubble.joraku.gui.panel.MainPanel;
import bubble.joraku.gui.panel.Panel;

import java.awt.Dimension;

public class Frame extends JFrame implements Updatable<GameState> {
    private final Panel mainPanel;
    
    public Frame(IController controller) {
        mainPanel = new MainPanel(controller);
        setContentPane(mainPanel);
        
        setSize(new Dimension(400, 400));
        setVisible(true);
    }

    @Override
    public void update(GameState newUpdate) {
        mainPanel.update(newUpdate);
    }
}
