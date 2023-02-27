package grp17;

import grp17.enums.e_Pack;
import grp17.enums.e_Rarity;

import java.security.SecureRandom;

public class Cards {
    private Hero hero;
    private e_Rarity rarity;

    public Cards(){}
    public Cards(Hero hero, e_Rarity rarity) {
        this.hero = hero;
        this.rarity = rarity;
    }

    public e_Rarity getRarityOfCardByTypePack(e_Pack type) {
        SecureRandom sRand = new SecureRandom();
        Cards card = new Cards();

        switch(type) {
            case SILVER: {
                int rand = sRand.nextInt(100) + 1;
                if(rand >= 1 && rand <= 5) {
                    card.rarity = e_Rarity.LEGENDARY;
                } else if(rand >= 6 && rand <= 25) {
                    card.rarity = e_Rarity.RARE;
                } else {
                    card.rarity = e_Rarity.COMMON;
                }
                break;
            }

            case DIAMOND: {
                int rand = sRand.nextInt(100) + 1;
                if(rand >= 1 && rand <= 15) {
                    card.rarity = e_Rarity.LEGENDARY;
                } else if(rand >= 16 && rand <= 36) {
                    card.rarity = e_Rarity.RARE;
                } else {
                    card.rarity = e_Rarity.COMMON;
                }
                break;
            }

            default: {
                System.out.println("Le type de pack que vous avez choisi n'existe pas");
                break;
            }
        }
        return card.rarity;
    }


    // Getters et Setters
    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public e_Rarity getRarity() {
        return rarity;
    }

    public void setRarity(e_Rarity rarity) {
        this.rarity = rarity;
    }

}
