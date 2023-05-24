public class ThreadDemo02 {
    public static void main(String[] args) {
        Myrun1 myrun1 = new Myrun1();
        Thread thread = new Thread(myrun1, "窗口一");
        Thread thread1 = new Thread(myrun1, "窗口二");
        Thread thread2 = new Thread(myrun1, "窗口三");

        thread.start();
        thread1.start();
        thread2.start();

    }
}

class Myrun1 implements Runnable{
    private int count = 25;
    @Override
    public void run() {
        while (true){
            if (extracted()) break;
        }
    }

    //当前方法非static方法，默认锁为this
    //如果方法为static方法，锁为该类的字节码对象（Myrun1.class）
    private synchronized boolean extracted() {
        if(count > 0) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println(Thread.currentThread().getName() + "卖出一张票，还剩" + --count + "张票！！！" );
        }else {
            System.out.println(Thread.currentThread().getName() + ":票已经售罄！！！");
            return true;
        }
        return false;
    }
}
