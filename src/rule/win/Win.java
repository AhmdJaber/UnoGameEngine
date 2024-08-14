package rule.win;

import player.Player;

public abstract class Win {
    private final int points;

    public Win(int points) {
        this.points = points;
    }

    public abstract boolean win(Player player);

    public int getPoints() {
        return points;
    }
}
