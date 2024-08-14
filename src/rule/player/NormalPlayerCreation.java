package rule.player;

import player.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NormalPlayerCreation extends NumberedPlayerCreation{
    public NormalPlayerCreation(int numOfPlayers) {
        super(numOfPlayers);
    }

    @Override
    public List<Player> create() {
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < this.getNumOfPlayers(); i++){
            System.out.println("Enter the player's name: ");
            String name = sc.next();
            System.out.println("Enter the player's age: ");
            int age = sc.nextInt();
            players.add(new Player(name, age, 0, new ArrayList<>()));
        }
        return players;
    }
}