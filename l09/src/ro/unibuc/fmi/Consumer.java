package ro.unibuc.fmi;

import java.util.Random;

public class Consumer implements Runnable {

    private final String consumerName;

    private final SharedList sharedList;

    public Consumer(String consumerName, SharedList sharedList) {
        this.consumerName = consumerName;
        this.sharedList = sharedList;
    }

    @Override
    public void run() {
        while (0 < 1) {
            try {
                sharedList.consume(consumerName);
                Thread.sleep(new Random().nextInt(1500));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
