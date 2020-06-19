package ro.unibuc.fmi;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Being myBeing = new Being("Calin");
        myBeing.sayName();

        Hero hero = new Hero("Hero");

        List<Being> beingList = new ArrayList<>();
        beingList.add(myBeing);
        beingList.add(myBeing);
        beingList.add(hero);

        System.out.println(beingList.size());
        for (Being being : beingList) {
            being.sayName();
        }

        Set<Being> beingSet = new HashSet<>();
        beingSet.add(myBeing);
        beingSet.add(myBeing);
        beingSet.add(hero);
        System.out.println(beingSet.size());

        Being myBeing2 = new Being("Calin");
        beingSet.add(myBeing2);
        System.out.println(beingSet.size());


        System.out.println("Hashcode for myBeing: " + myBeing.hashCode());
        System.out.println("Hashcode for myBeing2: " + myBeing2.hashCode());

        for (Being being : beingSet) {
            being.sayName();
        }

        Map<Being, Integer> beingToAttackPowerMapping = new LinkedHashMap<>();
        beingToAttackPowerMapping.put(myBeing, 15);
        beingToAttackPowerMapping.put(hero, 25);

        System.out.println("Attack power for hero is : " + beingToAttackPowerMapping.get(hero));


        myBeing.fight(hero);

        Being a = new Being("3");
        Being b = new Being("1");
        Being c = new Being("2");

        List<Being> listOfBeings = new ArrayList<>();
        listOfBeings.add(a);
        listOfBeings.add(b);
        listOfBeings.add(c);

        for (Being being : listOfBeings) {
            being.sayName();
        }

        Collections.sort(listOfBeings);

        for (Being being : listOfBeings) {
            being.sayName();
        }

        for (Being being : listOfBeings) {
            System.out.println(being.getHp());
        }

        HpBeingComparator hpBeingComparator = new HpBeingComparator();
        Collections.sort(listOfBeings, hpBeingComparator);

        for (Being being : listOfBeings) {
            System.out.println(being.getHp());
        }

        BeingService beingService = new BeingService();
        beingService.registerBeing(myBeing);
        beingService.registerBeing(hero);

        beingService.getBeingByName("Calin").sayName();

        System.out.println(myBeing.getHp());
        System.out.println(hero.getHp());

        System.out.println(beingService.getBeingWithHighestHp().getHp());
    }
}
