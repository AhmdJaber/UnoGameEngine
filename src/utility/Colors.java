package utility;

import card.enums.Color;

import java.util.List;
import java.util.Scanner;

public class Colors {
    public static void printColors(List<Color> colors){
        System.out.println("Pick one color to set");
        for (Color color : colors) {
            if (color == Color.NONE){
                continue;
            }
            System.out.print(color + " ");
        }
        System.out.println();
    }

    public static Color pickColor(){
        Scanner sc = new Scanner(System.in);
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
