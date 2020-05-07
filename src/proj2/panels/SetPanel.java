package proj2.panels;

import proj2.cards.Card;

import javax.swing.*;
import java.util.HashSet;

public class SetPanel extends JPanel
{
    //private Set data;
    HashSet<Object> data;
    public JButton [] array = new JButton[4];

    public SetPanel(char index)
    {
        super();
        // data = new Set(Card.rank[index]); // Before
       // data = new Set(Card.rank[index]);
        Card card = new Card();
        data = new HashSet<>(card.rank[index]);
        //.getRank()

        for(int i = 0; i < array.length; i++){
            array[i] = new JButton("   ");
            add(array[i]);
        }
    }
}