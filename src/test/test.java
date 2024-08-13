package test;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
           start();
    }

    public static void start(){
        List<String> strings = new ArrayList<>();
        strings.add("Hello");
        strings.add("World");
        strings.add("Hello");
        strings.add("World");
        strings.add("Hello");
        strings.add("World");

        List<String> first = strings;
        List<String> second = strings;

        first.remove(first.size()-1);
        first.remove(first.size()-1);
        for (String s : second) {
            System.out.println(s);
        }
        System.out.println(strings);

    }

}
