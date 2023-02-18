package grp17.service;

import grp17.Player;
import grp17.port.in.PlayerService;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceImpl implements PlayerService {

    @Override
    public Player loginPlayer(Player player) {
        return new Player();
    }

    @Override
    public Player registerPlayer(Player player) {
        return new Player();
    }

    @Override
    public Player findPlayerById(Integer id) {
        return new Player();
    }
}
