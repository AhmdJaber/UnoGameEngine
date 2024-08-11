package rule.card;

import card.Card;
import card.Color;

import java.util.List;

public interface CardCreation {
    public List<Card> create(List<Color> colors);
}
