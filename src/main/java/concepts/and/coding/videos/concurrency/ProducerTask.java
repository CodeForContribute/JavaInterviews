package concepts.and.coding.videos.concurrency;

public class ProducerTask implements Runnable{
    SharedResource sharedResource;

    public ProducerTask(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        System.out.println("Producer thread: " + Thread.currentThread().getName());
        try {
            Thread.sleep(2000);
        }catch (Exception e){
            // some exception handing here
        }
        // add item is a synchronized method, so any one thread will go inside it
        sharedResource.addItem();
    }
}
