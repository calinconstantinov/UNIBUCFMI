package ro.unibuc.fmi;

import java.util.Comparator;

public class HpBeingComparator implements Comparator<Being> {

    @Override
    public int compare(Being o1, Being o2) {
        return o1.getHp().compareTo(o2.getHp());
    }
}
