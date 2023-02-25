package grp17.in.persistance;

import grp17.Cards;
import grp17.Specialities;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "cards")
public class CardsDB extends Cards {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private DeckDB deck;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "available_card_id")
    private AvailableCardsDB available_card_id;

    public Long getId() {
        return id;
    }

    public DeckDB getDeck() {
        return deck;
    }

    public void setDeck(DeckDB deck) {
        this.deck = deck;
    }

    public AvailableCardsDB getAvailable_card_id() {
        return available_card_id;
    }

    public void setAvailable_card_id(AvailableCardsDB available_card_id) {
        this.available_card_id = available_card_id;
    }
}
