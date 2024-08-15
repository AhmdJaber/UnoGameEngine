package rule.points;

import card.Card;
import game.Game;
import player.Player;

import java.util.List;

public interface CalculatePoints {
    public void calculate(Player player, Game game);
}
