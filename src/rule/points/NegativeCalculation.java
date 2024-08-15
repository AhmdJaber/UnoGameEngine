package rule.points;

import card.Card;
import game.Game;
import player.Player;

import java.util.List;

public class NegativeCalculation implements CalculatePoints{
    private NegativeCalculation(){

    }

    private static class SingletonHolder{
        private static final NegativeCalculation negativeCalculation = new NegativeCalculation();
    }

    public static NegativeCalculation getInstance(){
        return SingletonHolder.negativeCalculation;
    }

    @Override
    public void calculate(Player player, Game game) {
        if (player == null){
            throw new IllegalArgumentException("player is null");
        }

        if (player == game.getWinner()){
            return;
        }

        Integer count = player.getScore();
        List<Card> cards = player.getCards();
        for (Card card : cards) {
            count -= card.getPoints();
        }
        player.setScore(count);
    }
}
