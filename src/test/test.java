package test;

public class test {
    public static void main(String[] args) {
           start();
    }

    public static void start(){
        enum e {
            one,
            tow,
            three
        }

        String s = "hello";
        e en = e.valueOf(s);
        System.out.println(en);
    }

}
