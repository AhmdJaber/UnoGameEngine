package rule.card.distribute;

import card.Card;
import player.Player;
import rule.card.creation.NormalCardCreation;

import java.util.List;

public class NormalDistribution implements CardDistribution {
    private NormalDistribution(){

    }

    private static class SingletonHolder{
        private static final NormalDistribution normalDistribution = new NormalDistribution();
    }

    public static NormalDistribution getInstance(){
        return SingletonHolder.normalDistribution;
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
