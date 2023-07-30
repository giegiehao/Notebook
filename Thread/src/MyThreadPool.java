import java.util.concurrent.*;

public class MyThreadPool {
    /* 线程池 核心原理：
    1.创建一个线程池，开始线程数为空
    2.提交任务时，池子会创建新的线程池，任务执行完毕后，线程归还给池子，下次再有任务提交时，不需要创建新的线程，直接复用已有的线程；
    如果提交任务时没有空线程，再创建新线程
    3.如果提交任务时，没有空线程，线程数已达上限，任务就会排队等待
    * */

    /*
    Executors：线程池工具类，可以调用方法创建线程池
    public static ExecutorService newCachedThreadPool() --创建一个没有上限的线程池 （最大线程数为int的最大取值）
    public static ExecutorService newFixedThreadPool(int nThreads) --创建一个有上限的线程池
    * */
    public static void main(String[] args) {
        //1.创建一个有上限的线程池
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        //ThreadPoolExecutor线程池对象

        //2.提交任务
        executorService.submit(new Myrunnable());
        executorService.submit(new Myrunnable());
        executorService.submit(new Myrunnable());
        executorService.submit(new Myrunnable());
        executorService.submit(new Myrunnable());

        //3.关闭线程池
        executorService.shutdown();

        //============================================================================================

        //自定义线程池
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                3,//核心线程
                3,//临时线程
                60,//存活时间，60个单位时间后销毁
                TimeUnit.SECONDS,//单位
                new ArrayBlockingQueue<>(10),//任务队列：阻塞队列
                Executors.defaultThreadFactory(),//创建线程工厂
                new ThreadPoolExecutor.AbortPolicy()//任务拒绝策略
        );

        /*不断提交任务，会出现三个临界点：
        * 1.当核心线程满时，再提交任务会进入任务队列；
        * 2.当核心线程满，任务队列满时，再提交任务会创建临时线程；
        * 3.当核心线程满，任务队列满，临时线程满时，再提交就触发拒绝策略
        * */

        {
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
            pool.submit(new Myrunnable());
        }

        //关闭线程池
        pool.shutdown();

        //获取可用线程
        int i = Runtime.getRuntime().availableProcessors();
        System.out.println(i);
    }
}

class Myrunnable implements Runnable{

    private static int i = 0;

    @Override
    public void run() {
        for (int t = 0; t < 10; t++) {
            synchronized (Myrunnable.class) {
                System.out.println(Thread.currentThread().getName() + "---" + i++);
            }
        }
    }
}
