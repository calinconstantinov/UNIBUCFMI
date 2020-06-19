package ro.unibuc.fmi.entities;

import java.util.Random;

public class MagicalMonster extends Monster {

    private Integer mana;

    public MagicalMonster(String name, Integer position, Integer hp, Integer mana) {
        super(name, position, hp);
        this.mana = mana;
    }

    @Override
    public Integer doDamage() {
        Integer damage = 1 + new Random().nextInt(7);

        if (new Random().nextBoolean() && mana > 0) {
            mana -= 5;
            damage += 2;
        }

        return damage;
    }
}
