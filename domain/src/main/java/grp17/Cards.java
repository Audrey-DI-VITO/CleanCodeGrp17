package grp17;

public class Cards {
    private Hero hero;
    private String rarity;

    public Cards(){}
    public Cards(Hero hero, String rarity) {
        this.hero = hero;
        this.rarity = rarity;
    }


    // Getters et Setters
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public String getRarity() {
        return rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }
}
