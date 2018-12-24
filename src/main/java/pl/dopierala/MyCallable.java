package pl.dopierala;

import java.sql.SQLOutput;
import java.util.concurrent.*;

public class MyCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> answerToEverything = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };

        ExecutorService execService = Executors.newFixedThreadPool(2);
        Future<Integer> result = execService.submit(answerToEverything);
//        while(!result.isDone()){
//            System.out.println("Brak wyniku, czekam...");
//            TimeUnit.SECONDS.sleep(2);
//        }

        Integer callableResult = null;
        try {
            callableResult = result.get(4, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(callableResult);
        execService.shutdown();
    }
}
