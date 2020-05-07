package proj2.cards;

import proj2.interfaces.SetInterface;

public class Set extends Hand implements SetInterface {
    /*
     *    Must override the behavior of the HandInterface so that
     *   a Set only accepts a card if it is of the same rank.
     */
    //ArrayList<Card> setArray;

//    public Set(){
//        setArray = new ArrayList<Card>();
//    }

    public void addCard(Card card){
      cardArray.add(card);
    }
    /**
     *   returns the rankIndex of the set
     @return int returns int corresponding to rank as defined in CardInterface
     */
    public int getRankIndex(){
        Card card;
        card = cardArray.get(0);

        char rank = card.getRank();

        return card.getRankIndex(rank);
    }

    /**
     *   returns the rank of the set
     *  @return char returns char of rank as defined in CardInterface
     */
    public char getRank(){
        Card card;
        card = cardArray.get(0);

        char rank = card.getRank();

        return rank;
    }
    /**
     *  Determines whether Set contains all four cards.
     @return if true then no more Card may be added to the set
     */
    public boolean isFull(){
        return cardArray.size() == 3;
    }



    public int length(){
        return cardArray.size();
    }
    /**
     * Ranks the cards in a set according to their suit
     */

}
