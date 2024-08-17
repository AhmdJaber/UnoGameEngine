package rule.card.creation;

import card.Card;
import card.enums.Color;
import card.enums.Type;
import card.cards.action.*;
import card.cards.number.*;

import java.util.ArrayList;
import java.util.List;

public class StandardCardCreation implements CardCreation {
    private StandardCardCreation(){

    }

    private static class SingletonHolder{
        private static final StandardCardCreation standardCardCreation = new StandardCardCreation();
    }

    public static StandardCardCreation getInstance(){
        return SingletonHolder.standardCardCreation;
    }

    @Override
    public List<Card> create(List<Color> colors) {
        if (colors == null){
            throw new IllegalArgumentException("List<Color> is null");
        }
        List<Card> cards = new ArrayList<>();
        List<Card> validCards = new ArrayList<>();
        for (Color color : colors){
            if (color == Color.NONE){
                continue;
            }
            validCards.add(CardFactoryMethod.createCard("zero", color));
            validCards.add(CardFactoryMethod.createCard("one", color));
            validCards.add(CardFactoryMethod.createCard("two", color));
            validCards.add(CardFactoryMethod.createCard("three", color));
            validCards.add(CardFactoryMethod.createCard("four", color));
            validCards.add(CardFactoryMethod.createCard("five", color));
            validCards.add(CardFactoryMethod.createCard("six", color));
            validCards.add(CardFactoryMethod.createCard("seven", color));
            validCards.add(CardFactoryMethod.createCard("eight", color));
            validCards.add(CardFactoryMethod.createCard("nine", color));
            validCards.add(CardFactoryMethod.createCard("pass", color));
            validCards.add(CardFactoryMethod.createCard("reverse", color));
            validCards.add(CardFactoryMethod.createCard("draw2", color));
            validCards.add(CardFactoryMethod.createCard("wild", Color.NONE));
            validCards.add(CardFactoryMethod.createCard("wildDraw4", Color.NONE));
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
