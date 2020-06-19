package ro.unibuc.fmi;

public interface Nameable1 {

    default void sayName() {
        System.out.println("Nameable 1 -- I don't have a name :(");
    }
}
