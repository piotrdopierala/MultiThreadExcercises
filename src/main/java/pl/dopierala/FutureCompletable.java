package pl.dopierala;

import java.util.concurrent.*;

public class FutureCompletable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService execService = Executors.newFixedThreadPool(3);

        CompletableFuture.runAsync(() -> System.out.println("Watek: " + Thread.currentThread().getName()), execService);

        CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return 42;
        }, execService)
                .thenApply(r -> {
                    System.out.println("*2 " + Thread.currentThread().getName());
                    return (r * 2);
                })
                .thenApply(r -> {
                    System.out.println("+1 " + Thread.currentThread().getName());
                    return r + 1;
                })
                .thenAccept((x)->{
                    System.out.println("result "+Thread.currentThread().getName());
                    System.out.println(x);
                });

        execService.shutdown();
    }
}

