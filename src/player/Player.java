package player;

import card.Card;
import game.Game;

import java.util.List;
import java.util.Objects;

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

    public static void printScores(Game game){
        System.out.println("The score of the players after this round: ");
        for (Player player: game.getPlayers()){
            System.out.println("[ " + player.getName() + ": " + player.getScore() + " ]");
        }
    }

    @Override
    public void update(Game game) {
        game.getCalculatePoints().calculate(this, game);
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
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass() != object.getClass()){
            return false;
        }

        Player player = (Player) object;
        return Objects.equals(name, player.name) && Objects.equals(age, player.age) && Objects.equals(score, player.score) && Objects.equals(cards, player.cards);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score, cards);
    }
}
