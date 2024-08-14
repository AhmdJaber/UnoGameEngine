package rule.points;

import card.Card;
import player.Player;

import java.util.List;

public class PositiveCalculation implements CalculatePoints{
    @Override
    public void calculate(Player player, List<Card> cards) {
        if (player == null){
            throw new IllegalArgumentException("player is null");
        }
        Integer count = player.getScore();
        for (Card card : cards) {
            count += card.getPoints();
        }
       player.setScore(count);
    }
}
