package ro.unibuc.fmi;

public interface Nameable2 {

    default void sayName() {
        System.out.println("Nameable 2 -- I don't have a name :(");
    }
}
