package grp17.out.web;

import grp17.Cards;
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
    private AvailableCardsDB avc;

    @Column
    private int xp_hero = 0;

    @Column
    private int level_hero = 1;

    public Long getId() {
        return id;
    }

    public DeckDB getDeck() {
        return deck;
    }

    public void setDeck(DeckDB deck) {
        this.deck = deck;
    }

    public AvailableCardsDB getAvc() {
        return avc;
    }

    public void setAvc(AvailableCardsDB available_card_id) {
        this.avc = available_card_id;
    }

    public int getXp_hero() {
        return xp_hero;
    }

    public void setXp_hero(int xp_hero) {
        this.xp_hero = xp_hero;
    }

    public int getLevel_hero() {
        return level_hero;
    }

    public void setLevel_hero(int level_hero) {
        this.level_hero = level_hero;
    }
}
