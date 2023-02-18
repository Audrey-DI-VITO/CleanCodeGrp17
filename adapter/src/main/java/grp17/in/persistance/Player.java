package grp17.in.persistance;

import lombok.NoArgsConstructor;
import javax.persistence.*;

@Entity
@Table(name = "player")
@NoArgsConstructor
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "token")
    private int token;

    @Column(name = "nbrVictory")
    private int nbrVictory;

    /*public Player(String pseudo) {
        this.pseudo = pseudo;
        this.token = 4;
        this.deck = new Deck();
        this.deck.insertCard(new Cards(new Hero("Vearn","slayer"), e_Rarity.LEGENDARY.toString()));
        this.deck.getAllCards().get(0).getHero().setLevel(2);
    }*/



    // Getters et Setters
    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getNbrVictory() {
        return nbrVictory;
    }

    public void setNbrVictory(int nbrVictory) {
        this.nbrVictory = nbrVictory;
    }
}
