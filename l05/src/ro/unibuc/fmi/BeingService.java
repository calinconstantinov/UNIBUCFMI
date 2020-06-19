package ro.unibuc.fmi;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BeingService {

    private List<Being> beingList = new ArrayList<>();

    private HpBeingComparator hpBeingComparator = new HpBeingComparator();

    public void registerBeing(Being being) {
        beingList.add(being);
    }

    public Being getBeingByName(String name) {
        for (Being being : beingList) {
            if (being.getName().equals(name)) {
                return being;
            }
        }
        return null;
    }

    public Being getBeingWithHighestHp() {
        beingList.sort(Collections.reverseOrder(hpBeingComparator));
        return beingList.get(0);
    }

}
