package grp17;


import grp17.enums.e_Rarity;

import java.util.ArrayList;

public class tmp {
    public ArrayList<Player> people = new ArrayList<>();
    public tmp(){
        people.add(new Player("toto"));
        people.add(new Player("tata"));
        people.add(new Player("tutu"));
        people.add(new Player("tete"));
        people.add(new Player("titi"));
        people.get(0).getDeck().insertCard(new Cards(new Hero("Dai","slayer"), e_Rarity.COMMON));
        people.get(0).getDeck().getAllCards().get(0).getHero().setLevel(2);
        people.get(0).getDeck().insertCard(new Cards(new Hero("Pop","Tank"),e_Rarity.RARE));
        people.get(0).getDeck().insertCard(new Cards(new Hero("Mam","Mage"),e_Rarity.LEGENDARY));
        people.get(0).getDeck().insertCard(new Cards(new Hero("Avan","slayer"),e_Rarity.COMMON));
        people.get(0).getDeck().getAllCards().get(3).getHero().setLevel(3);
    }

    public ArrayList<Player> getPeople() {
        return people;
    }

    public void setPeople(ArrayList<Player> people) {
        this.people = people;
    }
}
