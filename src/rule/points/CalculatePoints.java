package rule.points;

import card.Card;
import player.Player;

import java.util.List;

public interface CalculatePoints {
    public void calculate(Player player, List<Card> cards);
}
