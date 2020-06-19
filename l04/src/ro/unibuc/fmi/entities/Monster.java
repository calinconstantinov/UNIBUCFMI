package ro.unibuc.fmi.entities;

public class Monster extends Being {

    public Monster(String name, Integer position, Integer hp) {
        super(name, position, hp);
    }

    @Override
    public Integer doDamage() {
        return 1;
    }
}
