package rule.card.distribute;

import card.Card;
import player.Player;

import java.util.List;

public interface CardDistribution {
    public void distribute(List<Card> cards, List<Player> players, Integer numOfInitCards);
}
