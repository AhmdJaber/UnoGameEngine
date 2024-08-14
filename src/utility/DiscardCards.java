package utility;

import card.Card;
import game.Game;
import rule.shuffle.RandomShuffle;

public class DiscardCards extends RandomShuffle {
    public static void discardToPile(Game game){
        Card card = game.getDiscard().remove(game.getDiscard().size() - 1);
        game.getPile().addAll(game.getDiscard());
        game.getDiscard().clear();
        game.getDiscard().add(card);
        game.getInitializeShuffle().shuffle(game.getPile());
    }
}
