package concepts.and.coding.videos.concurrency;

import java.util.ArrayList;
import java.util.concurrent.*;
import java.util.List;

public class FutureCompleteFutureCallableClientDemo {
    /*
    * Future - Interface which represents the result of the async task.
    * Means , it allows us to check if
    *   a . Computation is complete.
    *   b . Get the result
    *   c . Take care of exception if any etc.
    *
    * Callable - it represents the task which need to be executed just like Runnable.
    * But difference is
    *   a . Runnable don't have return type.
    *   b.  Callable has the capability to return the value.
    *
    * Runnable interface -
        * @FunctionalInterface
        * public interface Runnable{
        *   public abstract void run();
        * }
     *Callable interface
     * @FunctionalInterface
     * public interface Callable<V>{
     *      V call() throws Exception;
     * }
     * CompletableFuture
     *  - got introduced in java8
     *  - to help in async programming
     *  - we can consider it as an advanced version of Future.
     *  - provides additional capability of chaining.
    * */
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
        // new thread will be created and it will perform the task
//        threadPoolExecutor.submit(()->{
//            System.out.println("This is the task, which thread will execute");
//        });
        // main thread will continue processing - now,what if caller wants to know the status of the thread, whether
        // its completed or failed etc
        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        // UseCase 2 - new thread will be created and it will perform the task
        Future<?> futureObj = threadPoolExecutor2.submit(()->{
            try {
                Thread.sleep(1500);
                System.out.println("This is the task, which thread will execute");
            }catch (Exception e){
                //
            }
        });
        // caller is checking the status of the thread it created
        System.out.println(futureObj.isDone());
        try {
            futureObj.get(8,TimeUnit.SECONDS);
        }catch (Exception e){
            // some handling here
        }
        System.out.println(futureObj.isDone());
        try {
            futureObj.get();
        }catch (Exception e){
            // some handling here
        }
        System.out.println(futureObj.isDone());
        // UseCae - 3
        List<Integer>result = new ArrayList<Integer>();
        Future<List<Integer>>futureObj3 = threadPoolExecutor.submit(()->{
            result.add(100);
            System.out.println("Task2 with runnable and return object");
        },result);
        try {
            List<Integer>resultFromFutureObj = futureObj3.get();
            System.out.println(resultFromFutureObj.get(0));
        }catch (Exception e){
            // exception handling here
        }
        // UseCase - 4 - return the result of a task which is internally stored,
        // to the caller
        Future<List<Integer>>futureObj4 = threadPoolExecutor.submit(()->{
            System.out.println("Task3 with Callable >>>>>");
            List<Integer>resultObj = new ArrayList<>();
            for (int i = 0; i < 100_000_000;++i)
                resultObj.add(i);
            return resultObj;
        });
        try {
            // get calls are blocking call.
            List<Integer>output = futureObj4.get();
            System.out.println("element from the list: >>> " + output.get(0));
        }catch (Exception e){
            // some exception handling here
        }
        // CompletableFuture
        CompletableFuture<List<Integer>>asyncTask1 = CompletableFuture.supplyAsync( ()->{
            // this is the task which need to be completed by thread.
            List<Integer>resultObj = new ArrayList<>();
            for (int i = 0; i < 100_000_000;++i)
                resultObj.add(i);
            return resultObj;
        },threadPoolExecutor);
        try {
            List<Integer>resultObj = asyncTask1.get();
            System.out.println(resultObj.get(0));
        }catch (Exception e){
            // some exception here
        }
        System.out.println(" I am continuing my own shit >>>>>");
    }
}
