package proj2.cards;

import java.util.ArrayList;

public class MyStack {
    ArrayList<Card> cardArray;

    public MyStack(){
        cardArray = new ArrayList<Card>();
    }

    public void push(Card card){
        cardArray.add(card);
    }

    public Card top(){
        if(!cardArray.isEmpty()){
            Card card;
            card = cardArray.get(cardArray.size()-1);
            return card;
        }
        return null;

    }

    public Card pop(){
        if(!cardArray.isEmpty()){
            Card card;
            card = cardArray.get(cardArray.size()-1);
            cardArray.remove(cardArray.size()-1);
            return card;
        }

        return null;
    }

    public boolean isEmpty(){
        return cardArray.isEmpty();
    }



}
