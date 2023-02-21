package grp17;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Cards> deck = new ArrayList<>();

    public Deck(){
    }

    public void insertCard(Cards card){
        this.deck.add(card);
    }

    public void displayAllCard(){
        for (int i = 1; i < this.deck.size() + 1; i++) {
            System.out.println(i + " :" + deck.get(i-1).getHero().getName());
        }
    }

    public void displayAuthorizedCards(int authorizedLevel){
        for (int i = 0; i < this.deck.size(); i++) {
            if(this.deck.get(i).getHero().getLevel()>=authorizedLevel) {
                System.out.println(i+1 + " :" + deck.get(i).getHero().getName()+" , lvl: "+deck.get(i).getHero().getLevel());
            }
        }
    }



    //getter
    public ArrayList<Cards> getAllCards() {
        return deck;
    }
}
