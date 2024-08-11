package rule.win;

import player.Player;

public class NegativeWin implements Win{
    @Override
    public boolean win(Player player, Integer points) {
        // needs another implementation to win
        return player.getScore() == points;
    }
}
