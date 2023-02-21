package grp17.in.persistance;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "deck")
public class DeckDB {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToMany(cascade = CascadeType.ALL, targetEntity = DeckDB.class)
    @JoinColumn(name = "id_cards")
    private List<CardsDB> id_cards;


    // GETTERS AND SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<CardsDB> getId_cards() {
        return id_cards;
    }

    public void setId_cards(List<CardsDB> id_cards) {
        this.id_cards = id_cards;
    }
}

