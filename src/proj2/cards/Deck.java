package proj2.cards;

import proj2.interfaces.DeckInterface;

import java.util.ArrayList;
import java.util.Collections;

public class Deck implements DeckInterface {
    ArrayList<Card> cardArray;

    public Deck(){
        cardArray = new ArrayList<Card>();
    }

    /**
     *  returns next Card in a deck that is facing down without removing it
     *  El peek card del deck va para el handInterface o para la mano del jugador
     */
    public Card peek(){
//        return cardArray.get(cardArray.size()-1);
        if(cardArray.isEmpty()) return null;

        else{
            return cardArray.get(cardArray.size()-1);
        }
    }


    public void addCard(Card card){
        cardArray.add(card);
    }

    public int getSizeOfDeck(){
        return cardArray.size();
    }

    public Card dealCard(){
        Card card = cardArray.get(cardArray.size()-1);
        cardArray.remove(cardArray.size()-1);
        return card;
    }

    public Card removeCard(){
        Card card = cardArray.get(cardArray.size()-1);
        cardArray.remove(cardArray.size()-1);
        return card;
        //return null;
    }

    public void shuffle(){
        Collections.shuffle(cardArray);
    }

    public boolean isEmpty(){
        return cardArray.isEmpty();
    }

    public void restoreDeck(){
        cardArray.removeAll(cardArray);
    }

}