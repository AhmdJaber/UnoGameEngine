package utility.action;

import card.Card;
import game.Game;
import player.Player;
import utility.DiscardUtil;

import java.util.List;

public class DrawCards {
    private DrawCards(){
        throw new AssertionError("Utility class should not be instantiated");
    }

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
                DiscardUtil.discardToPile(game);
            }
            player.getCards().add(pile.remove(pile.size() - 1));
        }
    }
}
