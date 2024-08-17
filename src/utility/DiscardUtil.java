package utility;

import card.Card;
import game.Game;
import rule.shuffle.InitializeShuffle;
import rule.shuffle.RandomShuffle;

public class DiscardUtil {
    private DiscardUtil(){
        throw new AssertionError("Utility class should not be instantiated");
    }

    public static void discardToPile(Game game){
        Card card = game.getDiscard().remove(game.getDiscard().size() - 1);
        game.getPile().addAll(game.getDiscard());
        game.getDiscard().clear();
        game.getDiscard().add(card);
        InitializeShuffle randomShuffle = RandomShuffle.getInstance();
        randomShuffle.shuffle(game.getPile());
    }
}
