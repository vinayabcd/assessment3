package myjava.src;

class Counter {
    private int a = 0;

    // Synchronized method to increse the count
    public synchronized void increment() {
        a++;
    }

    // Method to get the present count
    public int getCount() {
        return a;
    }
}

class IncrementerThread extends Thread {
    private Counter counter;
    private int increments;

    public IncrementerThread(Counter counter, int increments) {
        this.counter = counter;
        this.increments = increments;
    }

    public void run() {
        for (int i = 0; i < increments; i++) {
            counter.increment();
        }
    }
}

public class Synchronization {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        int num = 6;
        int incrperthr = 600;

        IncrementerThread[] threads = new IncrementerThread[num];

        // Create and start multiple threads
        for (int i = 0; i < num; i++) {
            threads[i] = new IncrementerThread(counter, incrperthr);
            threads[i].start();
        }

        // Wait for all threads to finish
        for (IncrementerThread thread : threads) {
            thread.join();
        }

        // final count value
        System.out.println("Final count value: " + counter.getCount());
    }
}