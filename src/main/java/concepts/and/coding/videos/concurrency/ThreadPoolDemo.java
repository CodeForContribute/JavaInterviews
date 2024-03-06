package concepts.and.coding.videos.concurrency;

import java.util.concurrent.*;

class CustomRejectionHandler implements RejectedExecutionHandler{

    @Override
    public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
        // logging
        System.out.println("Task denied >>>> : " + r.toString());
    }
}

class CustomThreadFactory implements ThreadFactory{
    @Override
    public Thread newThread(Runnable r) {
        Thread th = new Thread(r);
        //th.setName("custom-thread");
        return th;
    }
}
public class ThreadPoolDemo {
    /*
    * ThreadPool -
    *   a. It's a collection of threads a.k.a workers, which are available to perform the submitted tasks.
    *   b. Once task completed, worker thread get back to thread pool and wait for the new task to get assigned to this.
    *   c. threads can be reused.
    *
    *  Adv.
    *   a. Thread creation time can be saved.
    *       - when each thread created,space is allocated to it(stack,heap,PC) and this takes time.
    *       - With thread, this can be avoided by reusing the thread.
    *   b. Overhead of managing the thread lifecycle can be removed.
    *       - Thread has different state like running,waiting,terminated etc. And managing thread state
    *       - includes complexity.
    *       - Thread pool abstracts away this management.
    *   c. - Increased the performance.
    *       - More threads means, more Context switching, using control over thread creation,excess context switching
    *        can be avoided.
    *  In java Thread Pool is implemented By ThreadPoolExecutor
    *  Executor <--- ExecutorService <-- ThreadPoolExecutor(Concrete impl)
     * Executor <--- ExecutorService <-- ForkJoinPool(Concrete Impl)
     * Executor <--- ExecutorService <-- ScheduledExecutorService <-- ScheduledThreadPoolExecutor(Concrete Impl).
     *
     * ThreadPoolExecutor
     *  - It helps to create a customizable ThreadPool
     * public ThreadPoolExecutor(int corePoolSize,int maximumPoolSize,
     *                          long keepAliveTime,
     *                          TimeUnit unit,
     *                          BlockingQueue<Runnable>workQueue,
     *                          ThreadPoolFactor threadFactory,
     *                          RejectedExecutionHandler handler)
     * - corePoolSize - number of threads are initially created and keep in the pool,even if they are idle.
     * - allowCoreThreadTimeOut - if this prop is set to True(default - false) - idle thread kept alive till
     *                             time specified by 'keepAliveTime'
     * - keepAliveTime - Thread,which are idle get terminated after this time.
     * - maxPoolSize - max number of thread allowed in a pool.
     *                  if no of thread are == corePoolSize and queue is also full, then new threads are created.
     *                  till its less than maxPoolSize.
             * Excess thread will remain in the pool,this pool is not shutdown or if allowCoreThreadTimeOut is setTo True, then
             * excess thread get terminated after remain idle for keepAliveTime.
     *
     * TimeUnit - for the keepAliveTime, whether Millisecond or Second or Hours etc.
     * BlockingQueue - Queue used to hold task,before they got picked by the worker thread.
     *  - Bounded Queue - Queue with fixed capacity like - ArrayBlockingQueue
     *  - UnBounded Queue - LinkedBlockingQueue
     *
     * ThreadFactory - factory for creating new thread,ThreadPoolExecutor use this to create new thread. this factory provide us an interface to
         *  - to give custom thread name.
         *  - to give custom thread priority
         *  - to set thread daemon flag etc.
     *  - RejectedExecutionHandler - handler for tasks that can not be accepted by thread pool.
     *      - Generally logging logic can pe put here
    * */
    public static void main(String[] args) {
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                2,
                5,
                1,
                TimeUnit.HOURS,
                new ArrayBlockingQueue<>(4),
                new CustomThreadFactory(),
                new CustomRejectionHandler()
        );
        poolExecutor.allowCoreThreadTimeOut(true);
         //create tasks and submit tasks
        for(int i = 0; i < 24;++i){
            poolExecutor.submit( ()->{
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread name : " + Thread.currentThread().getName());
                }catch (Exception e){
                    // some exception handling here
                }
            });
        }
        poolExecutor.shutdown();

        ThreadPoolExecutor fixedThreadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
        for(int i = 0; i < 24;++i){
            fixedThreadPoolExecutor.submit( ()->{
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread name : " + Thread.currentThread().getName());
                }catch (Exception e){
                    // some exception handling here
                }
            });
        }
        fixedThreadPoolExecutor.shutdown();

        ThreadPoolExecutor cachedThreadPoolExecutor =
                (ThreadPoolExecutor) Executors.newCachedThreadPool();
        for(int i = 0; i < 24;++i){
            cachedThreadPoolExecutor.submit( ()->{
                try {
                    Thread.sleep(5000);
                    System.out.println("Thread name : " + Thread.currentThread().getName());
                }catch (Exception e){
                    // some exception handling here
                }
            });
        }
        cachedThreadPoolExecutor.shutdown();
    }
}
