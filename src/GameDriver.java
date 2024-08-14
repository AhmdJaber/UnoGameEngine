import game.BasicGame;
import game.Game;

public class GameDriver {
    public static void main(String[] args) {
        Game game = BasicGame.getInstance();
        game.start();
    }
}