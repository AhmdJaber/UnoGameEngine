package rule.card.creation;

import card.Card;
import card.cards.action.*;
import card.cards.number.*;
import card.enums.Color;
import card.enums.Type;

public class CardFactoryMethod {
    public static Card createCard(String cardType, Color color){
        if (cardType.equalsIgnoreCase("zero"))
            return new Zero(Type.ZERO, color, 0);
        else if (cardType.equalsIgnoreCase("one"))
            return new One(Type.ONE, color, 1);
        else if (cardType.equalsIgnoreCase("two"))
            return new Two(Type.TWO, color, 2);
        else if (cardType.equalsIgnoreCase("three"))
            return new Three(Type.THREE, color, 3);
        else if (cardType.equalsIgnoreCase("four"))
            return new Four(Type.FOUR, color, 4);
        else if (cardType.equalsIgnoreCase("five"))
            return new Five(Type.FIVE, color, 5);
        else if (cardType.equalsIgnoreCase("six"))
            return new Six(Type.SIX, color, 6);
        else if (cardType.equalsIgnoreCase("seven"))
            return new Seven(Type.SEVEN, color, 7);
        else if (cardType.equalsIgnoreCase("eight"))
            return new Eight(Type.EIGHT, color, 8);
        else if (cardType.equalsIgnoreCase("nine"))
            return new Nine(Type.NINE, color, 9);
        else if (cardType.equalsIgnoreCase("pass"))
            return new Pass(Type.PASS, color, 20);
        else if (cardType.equalsIgnoreCase("reverse"))
            return new Reverse(Type.REVERSE, color, 20);
        else if (cardType.equalsIgnoreCase("draw2"))
            return new DrawTwo(Type.DRAW_TWO, color, 20);
        else if (cardType.equalsIgnoreCase("wild"))
            return new Wild(Type.WILD, color, 50);
        else if (cardType.equalsIgnoreCase("wildDraw4"))
            return new WildDrawFour(Type.WILD_DRAW_FOUR, color, 50);
        return null;
    }
}
