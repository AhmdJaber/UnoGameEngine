package rule.card.distribute;

import card.Card;
import player.Player;

import java.util.List;

public class StandardDistribution implements CardDistribution {
    private StandardDistribution(){

    }

    private static class SingletonHolder{
        private static final StandardDistribution standardDistribution = new StandardDistribution();
    }

    public static StandardDistribution getInstance(){
        return SingletonHolder.standardDistribution;
    }

    @Override
    public void distribute(List<Card> cards, List<Player> players, Integer numOfInitCards){
        if (cards == null){
            throw new IllegalArgumentException("List<Card> is null");
        }
        if (players == null){
            throw new IllegalArgumentException("List<Player> is null");
        }
        int currentPlayer = 0;
        for(int i = 0; i < numOfInitCards * players.size(); i++){
            currentPlayer = (currentPlayer + 1) % players.size();
            Player player = players.get(currentPlayer);
            player.getCards().add(cards.remove(cards.size() - 1));
        }
    }

}
