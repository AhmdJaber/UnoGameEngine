package player;

import card.Card;
import game.Game;

import java.util.List;
import java.util.Objects;

public class Player implements Observer{
    private final String name;
    private final Integer age;
    private Integer score;
    private List<Card> cards;

    private Player(PlayerBuilder playerBuilder){
        this.name = playerBuilder.name;
        this.age = playerBuilder.age;
        this.score = playerBuilder.score;
        this.cards = playerBuilder.cards;
    }

    public static class PlayerBuilder {
        private final String name;
        private Integer age;
        private Integer score;
        private List<Card> cards;

        public PlayerBuilder(String name){
            this.name = name;
        }

        public PlayerBuilder age(Integer age){
            this.age = age;
            return this;
        }

        public PlayerBuilder score(Integer score){
            this.score = score;
            return this;
        }

        public PlayerBuilder cards(List<Card> cards){
            this.cards = cards;
            return this;
        }

        public Player build(){
            return new Player(this);
        }
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }

    public String getName() {
        return name;
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
                " age=" + age +
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
