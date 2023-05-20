
public class RunnableDemo {
    public static void main(String[] args) {
        //1.创建runnable对象,表示线程需要执行的任务
        Myrun myrun = new Myrun();

        //2.创建线程对象，并把runnable对象传进去
        Thread thread = new Thread(myrun);
        Thread thread1 = new Thread(myrun);
        thread.setName("线程一");
        thread1.setName("线程二");
        //启动线程
        thread1.start();
        thread.start();
        System.out.println(thread.getPriority());//java中线程的优先级1-10，默认优先级为5

        Thread main = Thread.currentThread();
        System.out.println("main的优先级：" + main.getPriority());
        main.setPriority(10);
        Thread main1 = Thread.currentThread();
        System.out.println("main1的优先级：" + main1.getPriority());

    }
}

class Myrun implements Runnable{
    private int count = 0;//只有一个runnable对象，可以无需使用static
    final static Object obj = new Object();//锁对象
    @Override
    public void run() {
        while (true) {
           //同步代码块，需要一个唯一的锁对象，这里的锁对象是obj
            //每次while循环后线程都抢一次cpu
            //这里Myrun只有一个对象，也可以作为锁对象
            synchronized (this) {//当一个线程在同步代码块之内时，其它线程无法进入该代码块
                if (count < 100) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    //获取当前执行该方法的线程名字
                    Thread currentThread = Thread.currentThread();
                    System.out.println(currentThread.getName() + "hello word:" + (count++));
                }else {
                    break;
                }
            }
        }
    }
}
