package grp17.in.persistance;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@Table(name = "deck")
public class Deck {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(cascade = CascadeType.ALL, targetEntity = Deck.class)
    @JoinColumn(name = "id_player")
    private List<Integer> id_player;

}

