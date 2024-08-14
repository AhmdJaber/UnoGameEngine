package rule.card.creation;

import card.Card;
import card.enums.Color;

import java.util.List;

public interface CardCreation {
    public List<Card> create(List<Color> colors);
}
