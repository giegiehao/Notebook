import java.util.concurrent.CompletableFuture;

public class ABSupersede {
    private static int count = 0;
    private static Object look;
    public static void main(String[] args) {
        look = new Object();
//        CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(() -> {});开发中更常见的创建线程的方法
        new Thread(() -> {
            while (true) {
                synchronized (look) {
                    count++;
                    if (count > 100) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("a");
                    look.notifyAll();
                    try {
                        look.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                synchronized (look) {
                    count++;
                    if (count > 100) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println("b");
                    look.notifyAll();
                    try {
                        look.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}
