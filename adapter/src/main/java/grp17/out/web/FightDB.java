package grp17.out.web;

import grp17.Fight;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Table(name = "fight")
public class FightDB extends Fight {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY, generator = "native")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "attacker")
    private CardsDB attacker;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "defender")
    private CardsDB defender;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "winner")
    private CardsDB winner;

    public CardsDB getAttacker() {
        return attacker;
    }

    public void setAttacker(CardsDB attacker) {
        this.attacker = attacker;
    }

    public CardsDB getDefender() {
        return defender;
    }

    public void setDefender(CardsDB defender) {
        this.defender = defender;
    }

    public CardsDB getWinner() {
        return winner;
    }

    public void setWinner(CardsDB winner) {
        this.winner = winner;
    }

    public Long getId() {
        return id;
    }
}
