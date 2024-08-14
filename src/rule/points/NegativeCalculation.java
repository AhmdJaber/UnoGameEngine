package rule.points;

import card.Card;
import player.Player;

import java.util.List;

public class NegativeCalculation implements CalculatePoints{
    @Override
    public void calculate(Player player, List<Card> cards) {
        if (player == null){
            throw new IllegalArgumentException("player is null");
        }
        int count = player.getScore();
        for (Card card : cards) {
            count -= card.getPoints();
        }
        player.setScore(count);
    }
}
