package ro.unibuc.fmi;

import java.util.Objects;
import java.util.Random;

public class Being implements Nameable1, Nameable2, Comparable<Being> {

    private String name;

    private Integer hp;

    public Being(String name) {
        this.name = name;
        hp = new Random().nextInt(10);
    }

    public Integer getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    @Override
    public void sayName() {
        System.out.println("Hello, my name is: " + name);
    }

    public <T extends Being> void fight(T anyType) {
        if (anyType instanceof Hero) {
            ((Hero) anyType).doSomething();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Being being = (Being) o;
        return Objects.equals(name, being.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public int compareTo(Being o) {
        return name.compareTo(o.getName());
    }
}
