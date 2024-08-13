package rule.card.creation;

import card.Card;
import card.Color;
import card.Type;
import card.cards.action.*;
import card.cards.number.*;

import java.util.ArrayList;
import java.util.List;

public class NormalCardCreation implements CardCreation {
    @Override
    public List<Card> create(List<Color> colors) {
        List<Card> cards = new ArrayList<>();
        List<Card> validCards = new ArrayList<>();
        for (Color color : colors){
            if (color == Color.NONE){
                continue;
            }
            validCards.add(new Zero(Type.ZERO, color, 0));
            validCards.add(new One(Type.ONE, color, 1));
            validCards.add(new Two(Type.TWO, color, 2));
            validCards.add(new Three(Type.THREE, color, 3));
            validCards.add(new Four(Type.FOUR, color, 4));
            validCards.add(new Five(Type.FIVE, color, 5));
            validCards.add(new Six(Type.SIX, color, 6));
            validCards.add(new Seven(Type.SEVEN, color, 7));
            validCards.add(new Eight(Type.EIGHT, color, 8));
            validCards.add(new Nine(Type.NINE, color, 9));
            validCards.add(new Pass(Type.PASS, color, 20));
            validCards.add(new Reverse(Type.REVERSE, color, 20));
            validCards.add(new DrawTwo(Type.DRAW_TWO, color, 20));
            validCards.add(new Wild(Type.WILD, Color.NONE, 50));
            validCards.add(new WildDrawFour(Type.WILD_DRAW_FOUR, Color.NONE, 50));
        }

        for (Card card : validCards){
            cards.add(card);
        }

        for (Card card : validCards){
            Type type = card.getType();
            if (type != Type.ZERO && type != Type.WILD && type != Type.WILD_DRAW_FOUR){
                cards.add(card);
            }
        }

        return cards;
    }
}
