package grp17.out.web;

import grp17.Deck;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "deck")
@NoArgsConstructor
public class DeckDB extends Deck {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "player_id")
    private PlayerDB player;

    @OneToMany(mappedBy = "deck", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CardsDB> cards = new ArrayList<>();

    // GETTERS AND SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PlayerDB getPlayer() {
        return player;
    }

    public void setPlayer(PlayerDB player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "DeckDB{" +
                "id=" + id +
                ", player=" + player +
                ", cards=" + cards +
                '}';
    }
}

