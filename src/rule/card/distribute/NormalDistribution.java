package rule.card.distribute;

import card.Card;
import player.Player;

import java.util.List;

public class NormalDistribution implements CardDistribution {
    @Override
    public void distribute(List<Card> cards, List<Player> players, Integer numOfInitCards){
        int currentPlayer = 0;
        for(int i = 0; i < numOfInitCards * players.size(); i++){
            currentPlayer = (currentPlayer + 1) % players.size();
            Player player = players.get(currentPlayer);
            player.getCards().add(cards.remove(cards.size() - 1));
        }
    }

}
