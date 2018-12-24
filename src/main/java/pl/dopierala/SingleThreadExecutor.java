package pl.dopierala;


import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingleThreadExecutor {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Glowny watek aplikacji: " + Thread.currentThread().getName());
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Runnable countdown = () -> {
            try {
                System.out.println("Wykonywany watek (count down): " + Thread.currentThread().getName());
                for (int i = 1; i <= 10; i++) {
                    System.out.println(i);
                    TimeUnit.MILLISECONDS.sleep(100);
                    //Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        Runnable blastoff = ()->{
            System.out.println("Wykonywany watek (blastoff):"+Thread.currentThread().getName());
            System.out.println("BLAST OFF!");
        };

        executor.submit(countdown);
        executor.submit(blastoff);
        executor.shutdown();
    }
}
