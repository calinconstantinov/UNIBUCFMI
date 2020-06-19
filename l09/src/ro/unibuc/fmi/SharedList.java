package ro.unibuc.fmi;

import java.util.LinkedList;
import java.util.List;

public class SharedList {

    private static final int CAPACITY = 5;

    private final List<Integer> list = new LinkedList<>();

    public void produce(String producerName, Integer value) throws InterruptedException {
        synchronized (list) {
            while (list.size() == CAPACITY) {
                System.out.println(producerName + " -- list is full!");
                list.wait();
            }

            list.add(value);
            System.out.println(producerName + " -- produced: " + value + " -- list size now: " + list.size());
            list.notifyAll();
        }
    }

    public Integer consume(String consumerName) throws InterruptedException {
        synchronized (list) {
            while (list.isEmpty()) {
                System.out.println(consumerName + " -- list is empty!");
                list.wait();
            }

            Integer value = list.remove(0);
            System.out.println(consumerName + " -- consumed: " + value + " -- list size now: " + list.size());
            list.notifyAll();
            return value;
        }
    }
}
