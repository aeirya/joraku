package bubble.joraku.gui.panel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import bubble.joraku.game.core.GameState;
import bubble.joraku.gui.interfaces.IController;
import bubble.joraku.gui.interfaces.Updatable;

public class Panel extends JPanel implements Updatable<GameState> {
    private transient final IController controller;
    private final Panel parent;
    private final List<Panel> observers;
        
    protected Panel(IController controller, Panel parent) {
        this.controller = controller;
        this.parent = parent;        
        observers = new ArrayList<>();
    }

    protected IController getController() {
        return controller;
    }

    /** TODO: edit or remove this */
    public void setSize(float x, float y) {
        Dimension parentSize = parent.getSize();
        setSize(
            new Dimension((int)(parentSize.width * x), (int)(parentSize.height * y))
            );
    }

    private void registerObserver(Panel updatable) {
        // System.out.println("reigstering child: " + updatable.getClass().getName());
        observers.add(updatable);
    }

    @Override
    protected void addImpl(Component comp, Object constraints, int index) {
        if (comp instanceof Panel) {
            registerObserver((Panel) comp);
        }
        super.addImpl(comp, constraints, index);
    }

    @Override
    public void update(GameState state) {
        for (Panel panel : observers) {
            panel.update(state);
        }
    }
}
