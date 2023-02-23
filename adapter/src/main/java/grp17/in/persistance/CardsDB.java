package grp17.in.persistance;

import grp17.Cards;
import grp17.Specialities;
import grp17.enums.e_Rarity;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "cards")
public class CardsDB extends Cards {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @Column(name = "name_card")
    private String name_card;

    @Column(name = "xp")
    private int xp;

    @Column(name = "speciality")
    @Embedded
    private Specialities speciality;

    @Column(name = "rarity")
    private String rarity;

    @Column(name = "level")
    private int level;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deck_id")
    private DeckDB deck;

    public Long getId() {
        return id;
    }

    public String getName_card() {
        return name_card;
    }

    public void setName_card(String name_card) {
        this.name_card = name_card;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public Specialities getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Specialities speciality) {
        this.speciality = speciality;
    }

    @Override
    public e_Rarity getRarity() {
        return e_Rarity.valueOf(rarity);
    }

    @Override
    public void setRarity(e_Rarity rarity) {
        this.rarity = String.valueOf(rarity);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public DeckDB getDeck() {
        return deck;
    }

    public void setDeck(DeckDB deck) {
        this.deck = deck;
    }
}
