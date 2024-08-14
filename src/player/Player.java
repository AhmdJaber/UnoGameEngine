package player;

import card.Card;
import game.Game;

import java.util.List;

public class Player implements Observer{
    private String name;
    private Integer age;
    private Integer score;
    private List<Card> cards;

    public Player(String name, Integer age, Integer score, List<Card> cards) {
        this.name = name;
        this.age = age;
        this.score = score;
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public void addCard(Card card) {
        this.cards.add(card);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return name + "{" +
                ", age=" + age +
                ", score=" + score +
                ", cards=" + cards +
                '}';
    }

    @Override
    public void update(Game game, List<Card> cards) {
        game.getCalculatePoints().calculate(this, cards);
    }
}