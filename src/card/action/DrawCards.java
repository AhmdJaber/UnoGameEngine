package card.action;

import card.Card;
import game.Game;
import player.Player;
import utility.DiscardCards;

import java.util.List;

public class DrawCards {
    public static void draw(Game game, Player player, Integer numOfCards){
        if (game == null){
            throw new IllegalArgumentException("Game is null");
        }
        if (player == null){
            throw new IllegalArgumentException("Player is null");
        }
        List<Card> pile = game.getPile();
        for (int i = 0; i < numOfCards; i++){
            if (pile.isEmpty()){
                DiscardCards.discardToPile(game);
            }
            player.getCards().add(pile.remove(pile.size() - 1));
        }
    }
}
