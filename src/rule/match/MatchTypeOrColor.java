package rule.match;

import card.Card;
import card.enums.Color;

public class MatchTypeOrColor implements Match{
    private MatchTypeOrColor(){

    }

    private static class SingletonHolder{
        private static final MatchTypeOrColor matchTypeOrColor = new MatchTypeOrColor();
    }

    public static MatchTypeOrColor getInstance(){
        return SingletonHolder.matchTypeOrColor;
    }

    @Override
    public boolean match(Card card1, Card card2) {
        if (card1 == null){
            throw new IllegalArgumentException("card 1 is null when trying to match");
        }
        if (card2 == null){
            throw new IllegalArgumentException("card 2 is null when trying to match");
        }

        return card1.getType() == card2.getType() || card1.getColor() == card2.getColor()
                || card1.getColor() == Color.NONE || card2.getColor() == Color.NONE;
    }
}
