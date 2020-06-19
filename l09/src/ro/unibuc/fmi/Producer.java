package ro.unibuc.fmi;

import java.util.Random;

public class Producer implements Runnable {

    private final String producerName;

    private final SharedList sharedList;

    public Producer(String producerName, SharedList sharedList) {
        this.producerName = producerName;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (0 < 1) {
            try {
                sharedList.produce(producerName, new Random().nextInt(150));
                Thread.sleep(new Random().nextInt(2500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
