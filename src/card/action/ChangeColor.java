package card.action;

import card.Color;
import game.Game;

import java.util.List;
import java.util.Scanner;

public class ChangeColor {
    public static Color change(Game game) {
        // remove duplicate "Pick one color to set"
        Scanner sc = new Scanner(System.in);
        System.out.println("Pick one color to set");
        List<Color> colors = game.getColors();
        for (Color color : colors) {
            if (color == Color.NONE){
                continue;
            }
            System.out.print(color + " ");
        }
        System.out.println();
        Color color;
        while (true){
            String input = sc.next().toUpperCase();
            try {
                color = Color.valueOf(input);
                if (color != Color.NONE){
                    break;
                }
                System.out.println("Can't pick the color 'NONE'");
            } catch (Exception e){
                System.out.println("Please enter a valid color");
            }
        }
        return color;
    }
}
