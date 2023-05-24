import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDeom01 {
    public static void main(String[] args) {
        Mylock mylock = new Mylock("窗口一");
        Mylock mylock1 = new Mylock("窗口二");
        Mylock mylock2 = new Mylock("窗口三");

        mylock.start();
        mylock1.start();
        mylock2.start();
    }
}


class Mylock extends Thread{
    private static int count = 0;
    private static Lock lock = new ReentrantLock();//锁对象，使用static关键字，使锁对象唯一

    public Mylock() {
    }

    public Mylock(String name) {
        super(name);
    }

    @Override
    public void run() {
        while (true){
            lock.lock();//线程抢锁
            try {
                if (count == 100) {
                    break;
                } else {
                    Thread.sleep(200);
                    count++;
                    System.out.println(Thread.currentThread().getName() + "正在卖:" + count);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {//finally语句始终执行。这里在break之前会执行finally。
                lock.unlock();//线程释放锁
            }
        }
    }
}