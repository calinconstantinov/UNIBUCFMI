package ro.unibuc.fmi;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }

        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        System.out.println(text);

        int c = Integer.parseInt("234");
        System.out.println(c);
    }
}
