package pl.dopierala;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class RaceCondition {
    public static void main(String[] args) throws InterruptedException {


        List<Integer> results = new ArrayList<Integer>();


        Counter cnt1 = new Counter(0);
        ExecutorService exec = Executors.newFixedThreadPool(8);
        for (int i = 0; i < 1000; i++) {
            exec.submit(cnt1::increase);
        }
        exec.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("------------------------");
        System.out.println(cnt1.getCnt());
        exec.shutdown();
    }


}

class Counter {
    AtomicInteger cnt;

    public Counter(int initalCntValue) {
        this.cnt= new AtomicInteger(initalCntValue);
    }

    public void increase() {
        //System.out.println("costam");
        //System.out.println("costam 2");
        //synchronized (this) {
            //this.cnt = this.cnt + 1;
        this.cnt.getAndIncrement();
        //}
        //System.out.println("costam 3");
    }

    public int getCnt() {
        return cnt.get();
    }
}
