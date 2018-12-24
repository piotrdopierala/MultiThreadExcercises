package pl.dopierala;

import java.util.stream.IntStream;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("Wykonywany watek: "+Thread.currentThread().getName());
        IntStream.rangeClosed(1,20).forEach(i->System.out.println(i+" | Wykonywany watek - "+Thread.currentThread().getName()));
    }
}
