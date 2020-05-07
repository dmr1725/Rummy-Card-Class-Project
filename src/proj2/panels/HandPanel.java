package proj2.panels;

import javax.swing.*;
import java.awt.*;

public class HandPanel extends JPanel
{

    public HandPanel(String name,JList hand, JButton stack, JButton deck, JButton lay, JButton layOnStack)
    {
        //model = hand.createSelectionModel();

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//		add(Box.createGlue());
        JLabel label = new JLabel(name);
        label.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(label);
        stack.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(Box.createGlue());
        add(stack);
        deck.setAlignmentX(Component.CENTER_ALIGNMENT);
//		add(Box.createGlue());
        add(deck);
        lay.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(lay);
        layOnStack.setAlignmentX(Component.CENTER_ALIGNMENT);
        add(layOnStack);
        add(Box.createGlue());
        add(hand);
        add(Box.createGlue());
    }

}