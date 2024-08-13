package card.action;

import card.Card;
import game.Game;
import player.Player;

import java.util.ArrayList;
import java.util.List;

public class DrawCards {
    public static void draw(Game game, Integer numOfCards){
        Player player = game.getPlayers().get((game.getCurrentPlayer() + game.getDirection() + game.getPlayers().size()) % game.getPlayers().size()); // duplicate code
        List<Card> pile = game.getPile();

        for (int i = 0; i < numOfCards; i++){
            if (pile.isEmpty()){
                shuffleDiscard(game);
            }
            player.getCards().add(pile.remove(pile.size() - 1));
        }
    }

    private static void shuffleDiscard(Game game){
        Card card = game.getDiscard().remove(game.getDiscard().size() - 1);
        game.setPile(game.getDiscard());
        game.getDiscard().clear();
        game.getDiscard().add(card);
        game.getInitializeShuffle().shuffle(game.getPile());
    }
}
