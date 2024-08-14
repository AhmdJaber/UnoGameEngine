package player;

import card.Card;
import game.Game;

import java.util.List;

public interface Observer {
    public void update(Game game, List<Card> cards);
}