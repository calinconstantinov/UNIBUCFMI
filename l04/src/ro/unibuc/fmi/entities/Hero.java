package ro.unibuc.fmi.entities;

import java.util.Random;

public class Hero extends Being implements Movable {

    public Hero(String name, Integer position, Integer hp) {
        super(name, position, hp);
    }

    @Override
    public Integer doDamage() {
        return 1 + new Random().nextInt(5);
    }

    @Override
    public Integer move(Integer distance) {
        Integer position = getPosition();
        position += distance;
        setPosition(position);
        return position;
    }
}
