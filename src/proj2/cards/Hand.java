package proj2.cards;

import proj2.interfaces.HandInterface;

import java.util.ArrayList;
import java.util.Collections;

public class Hand implements HandInterface {
    ArrayList<Card> cardArray;

    public Hand(){
        cardArray = new ArrayList<Card>();
    }


    public void addCard(Card card) {
        cardArray.add(card);
    }


    public Card getCard(int index) {
        if(cardArray.isEmpty()){
            return null;
        }
        else{
            return cardArray.get(index);
        }
    }

    public Card getCard(Card card) {
        if (!cardArray.isEmpty()) {
            for (int i = 0; i < cardArray.size(); i++) {
                if (cardArray.get(i) == card) return card;
            }
        }
        return null;
    }

    @Override
    public Card removeCard(Card card) {
        if(cardArray.isEmpty()){
            return null;
        }
        else{
            cardArray.remove(card);
            return card;
        }
    }

    @Override
    public Card removeCard(int index) {
        if(cardArray.isEmpty()){
            return null;
        }
        else{
            return cardArray.remove(index);
        }
    }


    public int getNumberOfCards() {
        if(cardArray.isEmpty()){
            return 0;
        }

        else{
            return cardArray.size();
        }
    }

    @Override
    public void sort() {
        int n = cardArray.size();
        cardArray.get(0).getRank();
        Card card1;
        Card card2;
        Card temp;

        for(int i = 0; i < n-1; i++){
            for(int j = 0; j < n -i-1; j++){
                // for card1
                card1 = cardArray.get(j);
                char suit1 = card1.getSuit();
                char rank1 = card1.getRank();
                int suitIndex1 = card1.getSuitIndex(suit1);
                int rankIndex1 = card1.getRankIndex(rank1);

                // for card2
                card2 = cardArray.get(j + 1);
                char suit2 = card2.getSuit();
                char rank2 = card2.getRank();
                int suitIndex2 = card2.getSuitIndex(suit2);
                int rankIndex2 = card2.getRankIndex(rank2);

                if(suitIndex1 > suitIndex2){
                    Collections.swap(cardArray, j+1, j);
                }

                if(suitIndex1 == suitIndex2){
                    if(rankIndex1 > rankIndex2){
                        Collections.swap(cardArray, j+1, j);
                    }
                }
            }
        }
    }

    @Override
    public boolean isEmpty() {
        return cardArray.isEmpty();
    }

    @Override
    public boolean containsCard(Card card) {
        for(int i = 0; i < cardArray.size(); i++){
            if(cardArray.get(i) == card) return true;
        }
        return false;
    }

    @Override
    public int findCard(Card card) {
        return 0;
    }

    public int getTotalPoints(){
        int total = 0;

        for(int i = 0; i < cardArray.size(); i++){
            char rank = cardArray.get(i).getRank();
            total += (cardArray.get(i).getRankPoints(rank));
        }
        return total;
    }

    public void showHand(){
        for(int i = 0; i < cardArray.size(); i++){
            Card card = cardArray.get(i);
            System.out.print(card + " , ");
        }
        System.out.println();
    }


    @Override
    public int compareTo(Object otherHandObject) {
        return 0;
    }

    @Override
    public int evaluateHand() {
        return 0;
    }
}
