package grp17.port.in;

import grp17.Player;

public interface PlayerService {
    Player registerPlayer(Player person);
    Player loginPlayer(Player person);
    Player findPlayerById(Integer id);
}
