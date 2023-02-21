package grp17.in.persistance;

import grp17.Deck;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "deck")
public class DeckDB extends Deck {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerDB player;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = DeckDB.class)
    @JoinColumn(name = "id_cards", referencedColumnName = "id")
    private List<CardsDB> id_cards;

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CardsDB> getId_cards() {
        return id_cards;
    }

    public void setId_cards(List<CardsDB> id_cards) {
        this.id_cards = id_cards;
    }

    public PlayerDB getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDB player) {
        this.player = player;
    }
}

