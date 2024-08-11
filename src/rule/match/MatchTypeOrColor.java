package rule.match;

import card.Card;

public class MatchTypeOrColor implements Match{
    @Override
    public boolean match(Card card1, Card card2) {
        return card1.getType() == card2.getType() || card1.getColor() == card2.getColor();
    }
}
