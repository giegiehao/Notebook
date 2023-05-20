public class ThreadDemo01 {
    /* join线程插入
    * 在当前线程之前先执行injo的线程
    * */

    public static void main(String[] args) throws InterruptedException {
        Mythread01 mythread01 = new Mythread01("线程一");
        mythread01.start();
        mythread01.join();//在目前线程插入线程，使该线程继续执行之前要先执行完插入的线程

        for (int i = 0; i < 10; i++) {
            System.out.println("main:" + i);
        }
    }
}

class Mythread01 extends Thread{
    public Mythread01() {
    }

    public Mythread01(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + i);
        }
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

