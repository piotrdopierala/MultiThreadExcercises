package pl.dopierala;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class FixedThreadPool {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Glowny watek aplikacji: " + Thread.currentThread().getName());
        ExecutorService executor = Executors.newFixedThreadPool(2);

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

        executor.submit(worker1);
        executor.submit(worker2);
        executor.submit(worker3);
        executor.shutdown();

    }
}
