package ro.unibuc.fmi;

import java.util.ArrayList;
import java.util.List;

public class ExperimentThree {

    public static void main(String[] args) {
        SharedList sharedList = new SharedList();

        List<Thread> producers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            producers.add(new Thread(new Producer("Producer" + i, sharedList)));
        }
        producers.forEach(Thread::start);

        List<Thread> consumer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            consumer.add(new Thread(new Consumer("Consumer" + i, sharedList)));
        }
        consumer.forEach(Thread::start);
    }
}
