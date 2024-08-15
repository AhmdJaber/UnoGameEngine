package rule.points;

import card.Card;
import game.Game;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class PositiveCalculation implements CalculatePoints{
    private PositiveCalculation(){

    }

    private static class SingletonHolder{
        private static final PositiveCalculation positiveCalculation = new PositiveCalculation();
    }

    public static PositiveCalculation getInstance(){
        return SingletonHolder.positiveCalculation;
    }

    @Override
    public void calculate(Player player, Game game) {
        if (player == null){
            throw new IllegalArgumentException("player is null");
        }
        if (player != game.getWinner()){
            return;
        }

        List<Card> allPlayersCards = new ArrayList<>();
        for (Player currentPlayer : game.getPlayers()){
            allPlayersCards.addAll(currentPlayer.getCards());
        }

        Integer count = player.getScore();
        for (Card card : allPlayersCards) {
            count += card.getPoints();
        }
       player.setScore(count);
    }
}
