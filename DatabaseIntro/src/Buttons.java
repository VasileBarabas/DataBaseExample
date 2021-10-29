

import javax.swing.*;
import java.awt.event.ActionListener;

public abstract class Buttons extends JButton implements ActionListener {

    public Buttons (String text) {
        this.setFocusable(false);
        this.setText(text);
    }
}
