package bubble.joraku.gui.panel;

import java.util.StringJoiner;

import java.awt.*;

import javax.swing.JLabel;

import bubble.joraku.game.board.Area;
import bubble.joraku.game.core.GameState;
import bubble.joraku.gui.interfaces.IController;

public class AreaPanel extends Panel {

    private final JLabel label;
    private final int index;

    protected AreaPanel(IController controller, Panel parent, int index) {
        super(controller, parent);
        label = new JLabel();
        setLayout(null);
        add(label);
        this.index = index;

        if (index % 2 == 0) setBackground(new Color(100, 100, 100));
    }
    
    @Override
    public void update(GameState state) {
        super.update(state);
        Area area = state.getBoard().getArea(index);
        StringJoiner joiner = new StringJoiner("\n");
        area.getTroops().forEach(t -> {
            joiner.add(t.getColor().toString()+": " + t.getSize());
        });
        label.setText(joiner.toString());
    }
}
