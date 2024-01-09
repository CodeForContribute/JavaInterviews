package concepts.and.coding.videos.concurrency;


public class ThreadingIntroDemo {
    /*
     * Process -
     * is an instance of a program that is getting executed.
     * it has its own memory,thread etc. os allocate these resources to process when its created.
     * Compilation (javac Test.java) - generates bytecode that can be executed by JVM.
     * Execution(java Test) - now jvm starts the new process and run the main method of Test class.
     * while creating the process, "java MainClassName" command creates a new JVM instance. At the time of creating jvm instance
     * we can allocate and tell how much heap memory need to be allocated.
     * java -Xms256m -Xmx2g MainClassName
     * -Xms<size> - this sets the initial heap size,in the above case, it sets to 256MB.
     * -Xmx<size> - this allocates max heap size to 2GB, it jvm tries to access more RAM than 2GB - it will throw "OutOfMemoryError".
     *
     * Thread -
     * It is a lightweight process or smallest sequence of instructions that are executed by CPU independently.
     * One process can have multiple threads.
     * When process is created , it starts with a single thread aka main thread, from this thread, we can spawn multiple threads
     * It allows a program to perform the multiple task at the same time.
     * all threads share the same resources such as memory space but still can perform task independently.
     *
     * Benefits -
     *  Improved performance by task parallelism.
     *  Responsiveness
     *  Resource sharing
     * Challenges
     * Concurrency issue like Deadlock, data inconsistency etc.
     * Synchronized overhead.
     * Testing & Debugging is difficult.
     *
     * Thread LifeCycle
     *   New
     *       - Thread has been created but not started.
     *       - It is just an object in memory.
     *  Runnable -
     *      - Thread is ready to run.
     *      - Waiting for CPU time.
     * Running - when thread start executing its code.
     * Blocked - Different scenario where runnable thread goes into blocking state.
     *   - I/O - like reading from a file or database.
     *   - Lock acquired - if thread want to lock on a resource which is locked by other thread, it has to wait
     *  It Releases all the MONITOR LOCKS.
     * Waiting - Thread goes into this state
     *     - when we call the wait() method on this thread it goes to wait state,makes it non-runnable.
     *     - It goes back to runnable,once other thread calls notify() and notifyAll() method.
     *    It releases all the monitor locks.
     *
     * Timed waiting
     *   - Thread waits for specific period of time and comes back to runnable state,
     *   after specific condition met. like sleep(), join()
     * It does not release any monitor locks
     *
     * Terminated - life of thread is completed, can not be started back again.
     *
     *
     *
     * * JVM internals
     *   a. Code Segment
     *       - It contains the compiled BYTECODE(i.e, machine code) of the java program.
     *       - It is read only.
     *       - All threads within the same process, share the same code segment.
     *   b. Data segment
     *       - It contains the GLOBAL and STATIC variables.
     *       - All threads within the same process, share the same data segment.
     *       - Threads can read and modify the same data.
     *       - Synchronization is required between multiple threads.
     *   c. Heap
     *       - Objects created at runtime using "new" keyword are allocated in the heap.
     *       - It is shared among all threads of the same process(not to other process as they will have their own heap segment).
     *       - Threads can read and modify the heap data.
     *       - Synchronization is required between multiple threads.
     *   d. stack
     *       - Each thread has its own stack.
     *       - It manage method calls,local variables.
     *
     *   e. Register
     *       - When JIT(just in time) compiles converts the ByteCode into native machine code,
     *          it uses registers to optimize the generated machine code.
     *       - It helps in context switching.
     *       - Each thread hsa its own register.
     *
     *   f. Counter
     *       - It is also known as Program Counter - it points to the instruction which is getting executed.
     *       - It increments its counter after successfully execution of the instruction.
     *
     *
     *
     *   Part-2
     *   Thread creation ways
     *   1. Implementing 'Runnable' interface
     *   2. extending 'Thread' Class - It has init,run,sleep,start,stop,interrupt etc.
     *   note - internally Thread class implements Runnable interface - it has run method
     * */

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Going inside main method: " + Thread.currentThread().getName());
        ThreadCreationRunnable runnableObj = new ThreadCreationRunnable();
        Thread a = new Thread(runnableObj);
        a.start();
        a.join(); // main thread will wait for other threads to finish and then finish itself
        // otherwise main can finish at any time before or later to other thread.
        Thread b = new ThreadCreationUsingThread();
        b.start();
        b.join();
        // we have 2 ways to create threads
        // as one class can implement multiple interfaces(multiple interfaces supported in java). - this is most preferred way of creating thread
        // one class can extend only 1 class - multiple inheritance not supported in java.
        System.out.println("Finished main method: " + Thread.currentThread().getName());
    }
}
