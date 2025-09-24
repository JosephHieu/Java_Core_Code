package threads;

import java.util.concurrent.TimeUnit;

public class ThreadMain {

    public static void main(String[] args) {

        var currentThread = Thread.currentThread();
        System.out.println(currentThread.getClass().getName());

        System.out.println(currentThread.toString());
        printThreadState(currentThread);

        currentThread.setName("MainGuy");
        currentThread.setPriority(Thread.MAX_PRIORITY);
        printThreadState(currentThread);

        CustomThread customThread = new CustomThread();
        customThread.start();

        Runnable runnable = () -> {

            for (int i = 1; i <= 8; i++) {
                System.out.print(" 2 ");
                try {
                    TimeUnit.MILLISECONDS.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        Thread myThread = new Thread(runnable);
        myThread.start();

        for (int i = 1; i <= 3; i++) {
            System.out.print(" 0 ");
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public static void printThreadState(Thread thread) {

        System.out.println("---------------------");
        System.out.println("Thread ID: " + thread.getId());
        System.out.println("Thread name: " + thread.getName());
        System.out.println("Thread Priority: " + thread.getPriority());
        System.out.println("Threat State: " + thread.getState());
        System.out.println("Thread Group: " + thread.getThreadGroup());
        System.out.println("Thread is Alive: " + thread.isAlive());
        System.out.println("---------------------");
    }
}