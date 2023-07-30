import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueDemo {
    public static void main(String[] args) {
        /*
        * 阻塞队列：
        * 当该队列不能put或者take之后，相应的线程会进入阻塞状态
        * ArrayBlockingQueue：底层是数组，有界, 必须定义队列大小
        * LinkedBlockingQueue：底层是链表，无界, 队列长度可变，容量更大
        * */

        ArrayBlockingQueue<String> abq = new ArrayBlockingQueue<>(1);

        Cook cook = new Cook(abq);
        Foodis foodis = new Foodis(abq);

        cook.start();
        foodis.start();
    }
}

class Cook extends Thread{
    ArrayBlockingQueue abq;

    public Cook(ArrayBlockingQueue abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep(500);
                abq.put("面条");
                System.out.println("做了一碗面条");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Foodis extends Thread{
    ArrayBlockingQueue abq;

    public Foodis(ArrayBlockingQueue abq) {
        this.abq = abq;
    }

    @Override
    public void run() {
    while (true){
        try {
            Thread.sleep(1000);
            abq.take();
            System.out.println("吃货吃了一碗面条");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    }
}