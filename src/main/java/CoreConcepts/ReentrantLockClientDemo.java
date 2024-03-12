package CoreConcepts;

public class ReentrantLockClientDemo {
    public static void main(String[] args) {
        SharedResourceV2 sharedResourceV2 = new SharedResourceV2();
        Thread a = new Thread(sharedResourceV2::produce);
        Thread b = new Thread(sharedResourceV2::consume);
        b.start();
        a.start();
    }
}
