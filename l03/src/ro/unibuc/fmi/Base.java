package ro.unibuc.fmi;

public class Base {

    private int val;

/*
    public Base() {
        System.out.println("my default base constructor");
    }
*/

    public Base(int val) {
        System.out.println("constructor with one parameter");
        this.val = val;
    }

    public int getVal() {
        return val;
    }
}