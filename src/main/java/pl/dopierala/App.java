package pl.dopierala;


public class App {
    public static void main(String[] args) {
        Thread thread = new MyThread("My-Thread-1");
        Thread secondThread = new MyThread("My-Thread-2");
        Thread runnableThread = new Thread(new MyRunnable(), "My-Runable-1");

        thread.start();
        secondThread.start();
        runnableThread.start();

        System.out.println("Glowny watek aplikacji: " + Thread.currentThread().getName());
    }
}
