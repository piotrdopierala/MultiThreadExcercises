package pl.dopierala;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorInvoke {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> answerToEverything1 = () -> {
            TimeUnit.SECONDS.sleep(10);
            return 42;
        };

        Callable<Integer> answerToEverything2 = () -> {
            TimeUnit.SECONDS.sleep(13);
            return 43;
        };

        Callable<Integer> answerToEverything3 = () -> {
            TimeUnit.SECONDS.sleep(5);
            return 44;
        };

        List<Callable<Integer>> callableList = Arrays.asList(answerToEverything1,answerToEverything2,answerToEverything3);

        ExecutorService execService = Executors.newFixedThreadPool(3);

//        List<Future<Integer>> futures = execService.invokeAll(callableList);
//        for(Future<Integer> f : futures){
//            System.out.println(f.get());
//        }
        Integer futures = execService.invokeAny(callableList);
        System.out.println(futures);
        execService.shutdown();
    }
}

