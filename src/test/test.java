package test;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class test {
    public enum category{
        RED,
        GREEN,
        BLUE
    }

    public static void main(String[] args) {
           start();
    }

    public static void start(){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        category c = null;
        try{
            c = category.valueOf(s);
            System.out.println(c);
        } catch (Exception e){
            System.out.println("Please enter a valid category");
            start();
        }

    }

}
