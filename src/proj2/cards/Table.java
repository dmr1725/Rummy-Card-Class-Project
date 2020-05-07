package proj2.cards;

import proj2.panels.HandPanel;
import proj2.panels.SetPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This GUI assumes that you are using a 52 card deck and that you have 13 sets in the deck.
 * The GUI is simulating a playing table
 *
 * @author Patti Ordonez
 */
public class Table<Deck> extends JFrame implements ActionListener
{
    final static int numDealtCards = 9;
    JPanel player1;
    JPanel player2;
    JPanel deckPiles;
    JLabel deck;
    JLabel stack;
    JList p1HandPile;
    JList p2HandPile;
    proj2.cards.Deck cardDeck;
    //proj2.cards.Deck stackDeck;
    proj2.cards.MyStack myStack;
//    Deck cardDeck;
//    Deck stackDeck;

    SetPanel[] setPanels = new SetPanel[13];
    JLabel topOfStack;
    JLabel deckPile;

    JLabel handP1;

    JButton p1Stack;
    JButton p2Stack;

    JButton p1Deck;
    JButton p2Deck;

    JButton p1Lay;
    JButton p2Lay;

    JButton p1LayOnStack;
    JButton p2LayOnStack;

    DefaultListModel p1Hand;
    DefaultListModel p2Hand;
    Hand hand1; //player 1
    Hand hand2; //player 2

    Set setA = new Set(); // player
    Set set2 = new Set();
    Set set3 = new Set();
    Set set4 = new Set();
    Set set5 = new Set();
    Set set6 = new Set();
    Set set7 = new Set();
    Set set8 = new Set();
    Set set9 = new Set();
    Set setX = new Set();
    Set setJ = new Set();
    Set setQ = new Set();
    Set setK = new Set();

    Set set;

    boolean player1Turn = true;
    boolean player2Turn = false;



    private void deal(Card[] cards) {
        for (int i = 0; i < cards.length; i++) {
            cards[i] = (Card) cardDeck.dealCard();
        }
    }

    public Table() {
        super("The Card Game of the Century");

        setLayout(new BorderLayout());
        setSize(1200, 700);


//        cardDeck = new Deck();
        cardDeck = new proj2.cards.Deck();

        for (int i = 0; i < Card.suit.length; i++) {
            for (int j = 0; j < Card.rank.length; j++) {
                Card card = new Card(Card.suit[i], Card.rank[j]);
                cardDeck.addCard(card);
            }
        }
        cardDeck.shuffle();
//        stackDeck = new Deck();
       // stackDeck = new proj2.cards.Deck();
        myStack = new proj2.cards.MyStack();

        JPanel top = new JPanel();

        for (int i = 0; i < Card.rank.length; i++)
            setPanels[i] = new SetPanel((char)Card.getRankIndex(Card.rank[i]));


        top.add(setPanels[0]);
        top.add(setPanels[1]);
        top.add(setPanels[2]);
        top.add(setPanels[3]);

        player1 = new JPanel();

        player1.add(top);


        add(player1, BorderLayout.NORTH);
        JPanel bottom = new JPanel();


        bottom.add(setPanels[4]);
        bottom.add(setPanels[5]);
        bottom.add(setPanels[6]);
        bottom.add(setPanels[7]);
        bottom.add(setPanels[8]);

        player2 = new JPanel();


        player2.add(bottom);
        add(player2, BorderLayout.SOUTH);


        JPanel middle = new JPanel(new GridLayout(1, 3));

        p1Stack = new JButton("Stack");
        p1Stack.addActionListener(this);
        p1Deck = new JButton("Deck ");
        p1Deck.addActionListener(this);
        p1Lay = new JButton("Lay  ");
        p1Lay.addActionListener(this);
        p1LayOnStack = new JButton("LayOnStack");
        p1LayOnStack.addActionListener(this);


        Card[] cardsPlayer1 = new Card[numDealtCards];
        deal(cardsPlayer1);
        p1Hand = new DefaultListModel();
        // creando el hand
        hand1 = new Hand();
        for (int i = 0; i < cardsPlayer1.length; i++)
           hand1.addCard(cardsPlayer1[i]);
        hand1.sort();

        System.out.print("Initial Player 1: ");
        hand1.showHand();
        System.out.println();

        for (int i = 0; i < cardsPlayer1.length; i++){
            Card card = hand1.getCard(i);
            p1Hand.addElement(card);

        }


        p1HandPile = new JList(p1Hand);


        middle.add(new HandPanel("Player 1", p1HandPile, p1Stack, p1Deck, p1Lay, p1LayOnStack));

        deckPiles = new JPanel();
        deckPiles.setLayout(new BoxLayout(deckPiles, BoxLayout.Y_AXIS));
        deckPiles.add(Box.createGlue());
        JPanel left = new JPanel();
        left.setAlignmentY(Component.CENTER_ALIGNMENT);


        stack = new JLabel("Stack");
        stack.setAlignmentY(Component.CENTER_ALIGNMENT);

        left.add(stack);
        topOfStack = new JLabel();
        topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
        topOfStack.setAlignmentY(Component.CENTER_ALIGNMENT);
        left.add(topOfStack);
        deckPiles.add(left);
        deckPiles.add(Box.createGlue());

        JPanel right = new JPanel();
        right.setAlignmentY(Component.CENTER_ALIGNMENT);

        deck = new JLabel("Deck");

        deck.setAlignmentY(Component.CENTER_ALIGNMENT);
        right.add(deck);
        deckPile = new JLabel();
        deckPile.setIcon(new ImageIcon(Card.directory + "b.gif"));
        deckPile.setAlignmentY(Component.CENTER_ALIGNMENT);
        right.add(deckPile);
        deckPiles.add(right);
        deckPiles.add(Box.createGlue());
        middle.add(deckPiles);


        p2Stack = new JButton("Stack");
        p2Stack.addActionListener(this);
        p2Deck = new JButton("Deck ");
        p2Deck.addActionListener(this);
        p2Lay = new JButton("Lay  ");
        p2Lay.addActionListener(this);
        p2LayOnStack = new JButton("LayOnStack");
        p2LayOnStack.addActionListener(this);

        Card[] cardsPlayer2 = new Card[numDealtCards];
        deal(cardsPlayer2);
        p2Hand = new DefaultListModel();

        // creando el hand2
        hand2 = new Hand();
        for (int i = 0; i < cardsPlayer2.length; i++)
            hand2.addCard(cardsPlayer2[i]);
        hand2.sort();

        System.out.print("Initial Player 2: ");
        hand2.showHand();
        System.out.println();

        for (int i = 0; i < cardsPlayer2.length; i++){
            Card card = hand2.getCard(i);
            p2Hand.addElement(card);
        }

        p2HandPile = new JList(p2Hand);

        middle.add(new HandPanel("Player 2", p2HandPile, p2Stack, p2Deck, p2Lay, p2LayOnStack));

        add(middle, BorderLayout.CENTER);

        JPanel leftBorder = new JPanel(new GridLayout(2, 1));


        setPanels[9].setLayout(new BoxLayout(setPanels[9], BoxLayout.Y_AXIS));
        setPanels[10].setLayout(new BoxLayout(setPanels[10], BoxLayout.Y_AXIS));
        leftBorder.add(setPanels[9]);
        leftBorder.add(setPanels[10]);
        add(leftBorder, BorderLayout.WEST);

        JPanel rightBorder = new JPanel(new GridLayout(2, 1));

        setPanels[11].setLayout(new BoxLayout(setPanels[11], BoxLayout.Y_AXIS));
        setPanels[12].setLayout(new BoxLayout(setPanels[12], BoxLayout.Y_AXIS));
        rightBorder.add(setPanels[11]);
        rightBorder.add(setPanels[12]);
        add(rightBorder, BorderLayout.EAST);

    }

    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();

        if (p1Deck == src || p2Deck == src) {

            Card card = cardDeck.dealCard();
            Card card1;



            if (card != null) {
                if (player1Turn && src == p1Deck){
                    hand1.addCard(card);
                    hand1.sort();
                    p1Hand.removeAllElements();
                    System.out.println("Player 1");
                    System.out.println("    Added: " + card );

                    for(int i = 0; i < hand1.getNumberOfCards(); i++) {
                        card1 = hand1.getCard(i);
                        p1Hand.addElement(card1);
                    }

                }

                else{
                    if(player2Turn && src == p2Deck){
                        //p2Hand.addElement(card);
                        hand2.addCard(card);
                        hand2.sort();
                        p2Hand.removeAllElements();

                        for(int i = 0; i < hand2.getNumberOfCards(); i++){
                            card1 = hand2.getCard(i);
                            p2Hand.addElement(card1);
                        }
                        System.out.println("Player 2");
                        System.out.println("    Added: " + card );
                    }


                }

            }
            if (cardDeck.getSizeOfDeck() == 0){
                deckPile.setIcon(new ImageIcon(Card.directory + "blank.gif"));
                int total1 = hand1.getTotalPoints();
                int total2 = hand2.getTotalPoints();

                if(total1 < total2){
                    System.out.println("Points: " + total2 + " to " + total1);
                    System.out.println("Player 1 wins!");
                }
                else if(total2 < total1){
                    System.out.println("Points: " + total1 + " to " + total2);
                    System.out.println("Player 2 wins!");
                }
                else{
                    System.out.println("Points: " + total1 + " to " + total2);
                    System.out.println("It's a tie!");
                }
            }


        }

        if (p1Stack == src || p2Stack == src) {

            Card card = myStack.pop();
            Card card1;

            if (card != null) {

                if (player1Turn && p1Stack == src){
                    Card topCard = myStack.top();
                    if (topCard != null)
                        topOfStack.setIcon(topCard.getCardImage());
                    else
                        topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
                    ////////////////////
                    hand1.addCard(card);
                    hand1.sort();
                    p1Hand.removeAllElements();

                    for(int i = 0; i < hand1.getNumberOfCards(); i++){
                        card1 = hand1.getCard(i);
                        p1Hand.addElement(card1);
                    }
                    System.out.println("Player 1");
                    System.out.println("    Added: " + card);
                    ////////////////////

                }

                else{
                    if(player2Turn && src == p2Stack) {
                        Card topCard = myStack.top();
                        if (topCard != null)
                            topOfStack.setIcon(topCard.getCardImage());
                        else
                            topOfStack.setIcon(new ImageIcon(Card.directory + "blank.gif"));
                        ////////////////////
                        hand2.addCard(card);
                        hand2.sort();

                        p2Hand.removeAllElements();

                        for(int i = 0; i < hand2.getNumberOfCards(); i++){
                            card1 = hand2.getCard(i);
                            p2Hand.addElement(card1);
                        }
                        ////////////////////
                        System.out.println("Player 1");
                        System.out.println("    Added: " + card);
                    }

                }

            }

        }

        if (player1Turn && p1Lay == src) {
            Object[] cards = p1HandPile.getSelectedValues();

            if(cards != null){
                // es para saber que set escoger
                Card tempCard = (Card) cards[0];
                char rank = tempCard.getRank();
                int tempRankIndex = tempCard.getRankIndex(rank);
                set = chooseSet(rank);
                ///////////////////////////////

                if(set.isEmpty() && (cards.length == 3 || cards.length == 4)){
                    // este loop es para saber si todas las cartas en el array cards son del mismo rank
                    // si no son del mismo rank pues haces un return
                    for(int i = 0; i < cards.length; i++){
                        Card card = (Card) cards[i];
                        char cardRank = card.getRank();
                        int cardRankIndex = card.getRankIndex(cardRank);

                        if(tempRankIndex != cardRankIndex) return;
                    }
                    // este loop solo va a correr cuando estemos seguros que todas las cartas sean del mismo rank
                    for(int i = 0; i < cards.length; i++){
                        set.addCard((Card) cards[i]);
                    }


                }

                else if(set.length() == 3 && cards.length == 1){
                    for(int i = 0; i < cards.length; i++){
                        set.addCard((Card) cards[i]);
                    }
                }

                else if(set.isEmpty() && (cards.length == 1 || cards.length == 2)){
                    return;
                }


                System.out.print("    Laying: ");
                for (int i = 0; i < cards.length; i++) {
                    Card card = (Card) cards[i];
                    layCard(card);
                    //////////////////////
                    hand1.removeCard(card);
                    //////////////////////
                    p1Hand.removeElement(card);
                }

                if(hand1.isEmpty()){
                    int total2 = hand2.getTotalPoints();
                    System.out.println();
                    System.out.println("Player 1 wins!");
                    System.out.println("Points: " + total2 + " to " + 0);
                    return;

                }
                System.out.println();
                System.out.print("    Hand now: ");
                hand1.showHand();
                //System.out.println();
            }
            player1Turn = player1Turn ? false: true;
            player2Turn = player2Turn ? false: true;
        }


        if (player2Turn && p2Lay == src) {
            Object[] cards = p2HandPile.getSelectedValues();
            if (cards != null){
                // es para saber que set escoger
                Card tempCard = (Card) cards[0];
                char rank = tempCard.getRank();
                int tempRankIndex = tempCard.getRankIndex(rank);
                set = chooseSet(rank);
                ///////////////////////////////

                if(set.isEmpty() && (cards.length == 3 || cards.length == 4)){
                    // este loop es para saber si todas las cartas en el array cards son del mismo rank
                    // si no son del mismo rank pues haces un return
                    for(int i = 0; i < cards.length; i++){
                        Card card = (Card) cards[i];
                        char cardRank = card.getRank();
                        int cardRankIndex = card.getRankIndex(cardRank);

                        if(tempRankIndex != cardRankIndex) return;
                    }
                    // este loop solo va a correr cuando estemos seguros que todas las cartas sean del mismo rank
                    for(int i = 0; i < cards.length; i++){
                        set.addCard((Card) cards[i]);
                    }


                }

                else if(set.length() == 3 && cards.length == 1){
                    for(int i = 0; i < cards.length; i++){
                        set.addCard((Card) cards[i]);
                    }
                }

                else if(set.isEmpty() && (cards.length == 1 || cards.length == 2)){
                    return;
                }


                System.out.print("    Laying: ");
                for (int i = 0; i < cards.length; i++) {
                    Card card = (Card) cards[i];
                    layCard(card);
                    //////////////////////
                    hand2.removeCard(card);
                    //////////////////////
                    p2Hand.removeElement(card);
                }

                if(hand2.isEmpty()){
                    int total1 = hand1.getTotalPoints();
                    System.out.println();
                    System.out.println("Player 2 wins!");
                    System.out.println("Points: " + total1 + " to " + 0);
                    return;
                }

                System.out.println();
                System.out.print("    Hand now: ");
                hand2.showHand();
            }
            player1Turn = player1Turn ? false: true;
            player2Turn = player2Turn ? false: true;
        }

        if (player1Turn && p1LayOnStack == src) {
            int[] num = p1HandPile.getSelectedIndices();
            if(num.length > 1) return;
            if (num.length == 1) {
                Object obj = p1HandPile.getSelectedValue();
                if (obj != null) {
                    p1Hand.removeElement(obj);
                    //////////////////////////////my code
                    hand1.removeCard((Card) obj);

                    System.out.println("    Discarded: " + (Card) obj);

                    Card card = (Card) obj;
                    //stackDeck.addCard(card);

                    myStack.push(card);
                    ///////////////////
                    topOfStack.setIcon(card.getCardImage());
                }

                if(hand1.isEmpty()){
                    int total2 = hand2.getTotalPoints();
                    System.out.println();
                    System.out.println("Player 1 wins!");
                    System.out.println("Points: " + total2 + " to " + 0);
                }
            }

            System.out.print("    Hand now: ");
            hand1.showHand();
            System.out.println();

            player1Turn = player1Turn ? false: true;
            player2Turn = player2Turn ? false: true;
        }


        if (player2Turn && p2LayOnStack == src) {
            int[] num = p2HandPile.getSelectedIndices();
            if(num.length > 1) return;
            if (num.length == 1) {
                Object obj = p2HandPile.getSelectedValue();
                if (obj != null) {
                    p2Hand.removeElement(obj);
                    /////////////////////////////
                    hand2.removeCard((Card) obj);
                    System.out.println("    Discarded: " + (Card) obj);
                    /////////////////////////////
                    Card card = (Card) obj;
                    //stackDeck.addCard(card);
                    ////////////////////
                    myStack.push(card);
                    //////////////////
                    topOfStack.setIcon(card.getCardImage());
                }

                if(hand2.isEmpty()){
                    int total1 = hand1.getTotalPoints();
                    System.out.println();
                    System.out.println("Player 2 wins!");
                    System.out.println("Points: " + total1 + " to " + 0);
                    return;
                }

                System.out.print("    Hand now: ");
                hand2.showHand();
                System.out.println();
            }
            player1Turn = player1Turn ? false: true;
            player2Turn = player2Turn ? false: true;
        }


    }


    void layCard(Card card) {
        char rank = card.getRank();
        char suit = card.getSuit();
        int suitIndex = Card.getSuitIndex(suit);
        int rankIndex = Card.getRankIndex(rank);
        setPanels[rankIndex].array[suitIndex].setText(card.toString());
        System.out.print(card + " , ");
        setPanels[rankIndex].array[suitIndex].setIcon(card.getCardImage());
    }

     Set chooseSet(char rank) {
         switch (rank) {
             case 'a':
                 return setA;
             case '2':
                 return set2;
             case '3':
                 return set3;
             case '4':
                 return set4;
             case '5':
                 return set5;
             case '6':
                 return set6;
             case '7':
                 return set7;
             case '8':
                 return set8;
             case '9':
                 return set9;
             case 't':
                 return setX;
             case 'j':
                 return setJ;
             case 'q':
                 return setQ;
             case 'k':
                 return setK;
             default:
                 return null;
         }
     }



}




