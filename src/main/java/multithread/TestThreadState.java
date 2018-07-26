package multithread;

public class TestThreadState {
    public static void main(String... args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            while (true) {
                System.out.println(System.currentTimeMillis());
                try {
////                    Thread.sleep(1000000);
                    new Object().wait();
                    if (System.currentTimeMillis() < 100) break;
                } catch (InterruptedException ignored) {
                    ignored.printStackTrace();
                }
            }
        });
        thread.start();
        thread.join();
        System.out.println("Done");
    }
}
