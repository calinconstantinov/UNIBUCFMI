package ro.unibuc.fmi;

import ro.unibuc.fmi.entities.Hero;
import ro.unibuc.fmi.entities.MagicalMonster;
import ro.unibuc.fmi.entities.Monster;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Hero hero = new Hero("Calin", 0, 100);

        List<Monster> monsters = new LinkedList<>();
        Monster cov = new Monster("Coronavirus", 3, 5);
        Monster mers = new Monster("MERS", 4, 15);
        Monster sars = new MagicalMonster("SARS", 4, 18, 15);
        monsters.add(cov);
        monsters.add(mers);
        monsters.add(sars);

        Scanner sc = new Scanner(System.in);
        System.out.println("Hero is at position: " + hero.getPosition());
        while (hero.getPosition() != -1) {
            Integer distance = sc.nextInt();
            hero.move(distance);
            System.out.println("Hero is at position: " + hero.getPosition());

            for (Monster monster : monsters) {
                if (!monster.isAlive()) {
                    continue;
                }

                System.out.println("Monster " + monster.getName() +
                        " is at position: " + monster.getPosition());

                if (monster.getPosition().equals(hero.getPosition())) {
                    System.out.println("Fight!");
                    System.out.println("Hero HP: " + hero.getHp());
                    System.out.println("Monster " + monster.getName()
                            + " HP: " + monster.getHp());

                    while (hero.getHp() > 0 && monster.getHp() > 0) {
                        Integer heroDamage = hero.doDamage();
                        System.out.println("Hero is dealing damage: " + heroDamage);
                        monster.takeDamage(heroDamage);
                        System.out.println("Monster " + monster.getName()
                                + " HP: " + monster.getHp());

                        Integer monsterDamage = monster.doDamage();
                        System.out.println("Monster " + monster.getName()
                                + " is dealing damage: " + monsterDamage);
                        hero.takeDamage(monsterDamage);
                        System.out.println("Hero HP: " + hero.getHp());
                    }
                }
            }
        }
    }
}
