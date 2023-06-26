import java.util.concurrent.locks.ReentrantLock;

public class Practice01 {
    /*
    * 练习一：
    * 一共有一千张电影票，可以两个窗口领取，每次领取的间隔为3000毫秒
    * 使用多线程模拟过程并打印剩余票数
    * */

    public static void main(String[] args) {
        Office office = new Office(1000);//生产1000张票
        //生成两个窗口
        Window window = new Window();
        Thread thread1 = new Thread(window,"窗口一");
        Thread thread2 = new Thread(window,"窗口二");

        thread1.start();
        thread2.start();
    }
}

class Window implements Runnable{
    ReentrantLock lock;
    public Window() {
        lock = new ReentrantLock();
    }

    @Override
    public void run() {
        while (true){
            lock.lock();
            if (!Office.isIshave()){
                break;
            }
            try {
                Thread.sleep(3);
                Office.setTicketes();
                System.out.println(Thread.currentThread().getName() + "：卖出一张票，还剩" +  Office.getTicketes() + "张票");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            lock.unlock();
        }
    }
}

class Office{
    private static int ticketes;
    private static boolean ishave = true;

    public Office(int t) {
        ticketes = t;
    }

    public static int getTicketes() {
        return ticketes;
    }

    public static void setTicketes() {
        Office.ticketes--;
        if (ticketes == 0){
            ishave = false;
        }
    }

    public static boolean isIshave() {
        return ishave;
    }
}