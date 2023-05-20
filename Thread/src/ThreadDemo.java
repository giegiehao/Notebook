public class ThreadDemo {
    public static void main(String[] args) {
        /*
        * finally void setDaemon(boolean on)
        * 守护线程（备胎线程)
        * 当其它非守护线程执行完毕之后，守护线程也会陆续结束
        * */

        Mythread1 my = new Mythread1("女神");
        Mythread2 my2 = new Mythread2("备胎");

        my2.setDaemon(true);//设置my2为守护线程，它将在my结束之后停止

        my.start();
        my2.start();
    }
}

class Mythread1 extends Thread{
    public Mythread1() {
    }

    public Mythread1(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName() + i);
        }
    }
}

class Mythread2 extends Thread{
    public Mythread2() {
    }

    public Mythread2(String name) {
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+ i);
        }
    }
}
