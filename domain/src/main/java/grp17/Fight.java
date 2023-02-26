package grp17;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fight {
    private Player player;
    private Cards playerCard;
    private Player opponent;
    private Cards opponentCard;

    public Fight(){}
    public Fight(Player player, Player opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public List<String> battle(){
        double damage = 0;
        List<String> resume = new ArrayList<>();
        while(playerCard.getHero().getPv_hero() > 0 && opponentCard.getHero().getPv_hero() > 0) {
            if(playerCard.getHero().getSpeciality().againstWhoSpe.equalsIgnoreCase(opponentCard.getHero().getSpeciality().name_spe)) {
                damage = (playerCard.getHero().getSpeciality().power_spe *
                        (1 + ((double) playerCard.getHero().getSpeciality().supPower_spe / 100))
                        - opponentCard.getHero().getSpeciality().getArmor_spe()
                );
                opponentCard.getHero().setPv_hero((int) (opponentCard.getHero().getPv_hero() - damage));
            } else {
                damage = (playerCard.getHero().getSpeciality().power_spe - opponentCard.getHero().getSpeciality().armor_spe);
                opponentCard.getHero().setPv_hero((int) (opponentCard.getHero().getPv_hero() - damage));
            }
            resume.add("Le héros "+playerCard.getHero().getName_hero()+" a infligé "+damage+" points de dégâts au héro "+opponentCard.getHero().getName_hero());

            if(opponentCard.getHero().getPv_hero() <= 0) {
                break;
            }

            if(playerCard.getHero().getSpeciality().name_spe.equalsIgnoreCase(opponentCard.getHero().getSpeciality().againstWhoSpe.toUpperCase())) {
                damage = (opponentCard.getHero().getSpeciality().power_spe *
                        (1 + ((double) opponentCard.getHero().getSpeciality().supPower_spe / 100))
                        - playerCard.getHero().getSpeciality().armor_spe
                );
                playerCard.getHero().setPv_hero((int) (playerCard.getHero().getPv_hero() - damage));
            } else {
                damage = (opponentCard.getHero().getSpeciality().power_spe - playerCard.getHero().getSpeciality().armor_spe);
                playerCard.getHero().setPv_hero((int) (playerCard.getHero().getPv_hero() - damage));
            }
            resume.add("Le héros "+opponentCard.getHero().getName_hero()+" a infligé "+damage+" points de dégâts au héro "+playerCard.getHero().getName_hero());
        }

        if(playerCard.getHero().getPv_hero() > opponentCard.getHero().getPv_hero()) {
            resume.add("Le joueur "+player.getPseudo()+" a gagné");
        } else {
            resume.add("Le joueur "+opponent.getPseudo()+" a gagné");
        }
        winXP();
        return resume;
    }

    public void winXP() {
        if(playerCard.getHero().getPv_hero() > opponentCard.getHero().getPv_hero()) {
            playerCard.getHero().setXP(playerCard.getHero().getXP() + 1);
            playerCard.getHero().levelUp();
        } else {
            opponentCard.getHero().setXP(opponentCard.getHero().getXP() + 1);
            opponentCard.getHero().levelUp();
        }
    }


    //getter & setter
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }

    public Cards getPlayerCard() {
        return playerCard;
    }

    public Cards getOpponentCard() {
        return opponentCard;
    }

    public void setPlayerCard(Cards playerCard) {
        System.out.println("player card : "+playerCard);
        player = new Player("TEST");
        this.playerCard = playerCard;
    }

    public void setOpponentCard(Cards opponentCard) {
        System.out.println("player card : "+playerCard);
        opponent = new Player("TEST 3");
        this.opponentCard = opponentCard;
    }
}
