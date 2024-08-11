package card.actions;

import card.Color;
import game.Game;

import java.util.Scanner;

public class ColorAction {
    public static Color change(Game game) {
        // remove recursion
        // remove duplicate "Pick one color to set"
        // remove return null
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick one color to set");
        String input = sc.next().toUpperCase();
        try {
            return Color.valueOf(input);
        } catch (Exception e){
            System.out.println("Please enter a valid color");
            change(game);
        }

        return null;
    }
}
