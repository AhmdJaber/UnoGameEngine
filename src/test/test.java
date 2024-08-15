package test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
           start();
    }

    public static void start(){
        int age;
        while (true){
            Scanner sc = new Scanner(System.in);
            try{
                age = sc.nextInt();
            } catch (Exception e){
                System.out.println("Invalid age!");
                continue;
            }
            if (age > 0){
                break;
            }
            System.out.println("Enter a number greater than 0");
        }

    }

}
