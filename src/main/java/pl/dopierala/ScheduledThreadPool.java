package pl.dopierala;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {
    public static void main(String[] args) {
        System.out.println("Glowny watek aplikacji: " + Thread.currentThread().getName());
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

        Runnable worker1 = () -> {
            try {
                System.out.println("Robotnik 1 - Aktualny watek:" + Thread.currentThread().getName());
                System.out.println("Laduje butle z tlenem.");
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable worker2 = () -> {
            try {
                System.out.println("Robotnik 2 - Aktualny watek:" + Thread.currentThread().getName());
                System.out.println("Laduje zapas pozywienia.");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable worker3 = () -> {
            try {
                System.out.println("Robotnik 3 - Aktualny watek:" + Thread.currentThread().getName());
                System.out.println("Laduje paliwo.");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        executor.schedule(worker1,5,TimeUnit.SECONDS);
        executor.scheduleAtFixedRate(worker3,0,6,TimeUnit.SECONDS);
        //executor.shutdown();
    }
}
