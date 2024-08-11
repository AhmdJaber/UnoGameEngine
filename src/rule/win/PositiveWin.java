package rule.win;

import player.Player;

public class PositiveWin implements Win{
    @Override
    public boolean win(Player player, Integer points) {
        return player.getScore() >= points;
    }
}
