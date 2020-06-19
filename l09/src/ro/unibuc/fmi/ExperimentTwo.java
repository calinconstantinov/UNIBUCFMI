package ro.unibuc.fmi;

import java.util.List;
import java.util.TreeSet;

public class ExperimentTwo {

    public static void main(String[] args) throws InterruptedException {

        CompetingThread competingThread1 = new CompetingThread("Competitor 1");
        CompetingThread competingThread2 = new CompetingThread("Competitor 2");
        CompetingThread competingThread3 = new CompetingThread("Competitor 3");

        competingThread1.start();
        competingThread2.start();
        competingThread3.start();

        competingThread1.join();
        competingThread2.join();
        competingThread3.join();
        System.out.println("all done");

        new TreeSet<>(List.of(competingThread1, competingThread2, competingThread3))
                .forEach(System.out::println);
    }
}
