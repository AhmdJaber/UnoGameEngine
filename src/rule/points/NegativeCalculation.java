package rule.points;

import card.Card;
import player.Player;

public class NegativeCalculation implements CalculatePoints{
    @Override
    public Integer calculate(Player player) {
        Integer count = 0;
        for (Card card : player.getCards()) {
            count -= card.getPoints();
        }
        return count;
    }
}
