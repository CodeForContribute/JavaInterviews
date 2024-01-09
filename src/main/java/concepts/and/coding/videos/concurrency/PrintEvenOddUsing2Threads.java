package concepts.and.coding.videos.concurrency;

import java.util.Scanner;

public class PrintEvenOddUsing2Threads {

    private static int counter = 1;
    private static int n;

    public PrintEvenOddUsing2Threads(int n) {
        PrintEvenOddUsing2Threads.n = n;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // create an Object of the class - monitor locks we will use
        PrintEvenOddUsing2Threads printEvenOddUsing2Threads = new PrintEvenOddUsing2Threads(n);
        // since Runnable is a functional interface - we can implement its
        // single run method using lambda expression
        // create first thread - Thread - 1
        Thread a = new Thread(printEvenOddUsing2Threads::printEvenNumber);
        // create 2nd thread - Thread - 2
        Thread b = new Thread(printEvenOddUsing2Threads::printOddNumber);
        a.start();
        b.start();
    }

    private void printOddNumber() {
        synchronized (this) {
            while (counter < n) {
                // if counter is even, the thread calling this method will wait
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (Exception e) {
                        // some exception handling here
                    }
                }
                // if the counter val is not even
                // print it
                System.out.println("Thread >>> : " + Thread.currentThread().getName() + " Counter >>> : " + counter);
                // increment it
                counter++;
                // notify to the second thread
                notify();
            }
        }
    }

    private void printEvenNumber() {
        synchronized (this) {
            while (counter < n) {
                // if the counter value is odd printEvenThread will wait
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (Exception e) {
                        // some exception handling here
                    }
                }
                // if the counter value is even - it will print odd
                System.out.println("Thread >>> : " + Thread.currentThread().getName() + " Counter >>> : " + counter);
                //increment counter
                counter++;
                // notify to second thread
                notify();
            }
        }
    }
}
