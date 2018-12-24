package pl.dopierala;

import java.util.concurrent.*;

public class FutureCompletableJoin {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService execService = Executors.newFixedThreadPool(3);

        CompletableFuture<Long> userIdFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return getUserId();
        });

        CompletableFuture<Void> future = userIdFuture.thenCompose(userId -> CompletableFuture.supplyAsync(() -> {
            return getDiscount(userId);
        })).thenAccept(System.out::println);

        future.get();

        execService.shutdown();
    }

    public static long getUserId() {
        return 324L;
    }

    public static Double getDiscount(long userId) {
        return 0.15;
    }
}
