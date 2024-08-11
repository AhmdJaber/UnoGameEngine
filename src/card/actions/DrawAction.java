package card.actions;

import card.Card;
import game.Game;
import player.Player;

import java.util.List;

public class DrawAction {
    public static void draw(Game game, Integer numOfCards){
        if (game.getPile().size() < numOfCards){
            return;
            // handle it by the Discard cards
        }

        Player player = game.getPlayers().get((game.getCurrentPlayer() + game.getPlayers().size() + game.getDirection()) % game.getPlayers().size()); // duplicate code
        List<Card> pile = game.getPile();

        for (int i = 0; i < numOfCards; i++){
            player.getCards().add(pile.remove(pile.size() - 1));
        }
    }
}
