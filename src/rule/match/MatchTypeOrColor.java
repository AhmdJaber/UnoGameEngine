package rule.match;

import card.Card;

public class MatchTypeOrColor implements Match{
    @Override
    public boolean match(Card card1, Card card2) {
        if (card1 == null){
            throw new IllegalArgumentException("card 1 is null when trying to match");
        }
        if (card1 == null){
            throw new IllegalArgumentException("card 2 is null when trying to match");
        }

        return card1.getType() == card2.getType() || card1.getColor() == card2.getColor();
    }
}
