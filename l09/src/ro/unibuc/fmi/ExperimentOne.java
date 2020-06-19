package ro.unibuc.fmi;

public class ExperimentOne {

    static int accumulator = 0;

    public static void main(String[] args) throws InterruptedException {
        Runnable r = () -> {
            for (int i = 0; i < 1000; i++) {
                accumulator++;
            }
            System.out.println("Finished job!");
        };

        for (int i = 0; i < 10; i++) {
            new Thread(r).start();
        }

        Thread.sleep(3000);
        System.out.println(accumulator);
    }
}
