package ro.unibuc.fmi;

import java.time.Instant;

public class CompetingThread extends Thread implements Comparable<CompetingThread> {

    private final String competitorName;

    private long finishTime;

    public CompetingThread(String competitorName) {
        this.competitorName = competitorName;
    }

    @Override
    public void run() {
        long b = 0;
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                for (int k = 0; k < 10; k++) {
                    b += i * j * k;
                }
            }
        }
        finishTime = Instant.now().toEpochMilli();
    }

    public long getFinishTime() {
        return finishTime;
    }

    @Override
    public int compareTo(CompetingThread o) {
        return Long.compare(finishTime, o.getFinishTime());
    }

    @Override
    public String toString() {
        return "CompetingThread{" +
                "competitorName='" + competitorName + '\'' +
                ", finishTime=" + finishTime +
                '}';
    }
}
