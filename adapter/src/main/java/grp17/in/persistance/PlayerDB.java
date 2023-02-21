package grp17.in.persistance;

import grp17.Player;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "player")
@NoArgsConstructor
public class PlayerDB extends Player {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private int id;

    @Column(name = "pseudo")
    private String pseudo;

    @Column(name = "token")
    private int token;

    @Column(name = "nbrVictory")
    private int nbrVictory;

    @OneToMany(mappedBy = "player")
    private List<DeckDB> id_deck;

    public PlayerDB(String pseudo) {
        this.pseudo = pseudo;
        this.token = 4;
        this.id_deck = new ArrayList<>();
    }



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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<DeckDB> getId_deck() {
        return id_deck;
    }

    public void setId_deck(DeckDB id_deck) {
        this.id_deck.add(id_deck);
    }
}
