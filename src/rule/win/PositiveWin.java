package rule.win;

import player.Player;

public class PositiveWin extends Win{
    public PositiveWin(int points) {
        super(points);
    }

    @Override
    public boolean win(Player player) {
        if (player == null){
            throw new IllegalArgumentException("player is null");
        }

        return player.getScore() >= this.getPoints();
    }
}