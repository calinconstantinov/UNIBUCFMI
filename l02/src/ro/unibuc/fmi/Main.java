package ro.unibuc.fmi;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int element = 0;

        int[] a = new int[2];
        System.out.println(a.getClass());

        a[0] = 1;
        a[1] = 2;
        swap(a);
        System.out.println(a[0]);

        int[][] b = new int[5][10];
        System.out.println(b.getClass());

        b[0] = new int[5];
        b[1] = new int[6];
        b[2] = a;

        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[i].length; j++) {
                System.out.print(b[i][j]);
            }
            System.out.println("");
        }

        int c[] = {3, 4, 8, 1, 11};
        display1D(c);

        Arrays.sort(c);
        System.out.println("");
        display1D(c);

        System.out.println();
        System.out.println(Arrays.binarySearch(c, 1));
    }

    static void swap(int[] a) {
        int c = a[0];
        a[0] = a[1];
        a[1] = c;
    }

    static void display1D(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
