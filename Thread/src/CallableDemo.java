import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        /*
        * 特点：可以获取到多线程运行的结果
        * 1.创建一个类Mycallable实现Callable接口
        * 2.重写call方法（有返回值）
        *
        * 3.创建Mycallable对象（表示线程执行的任务）
        * 4.创建Futuretask对象（用于管理多线程返回的结果）
        * 5.创建Thread线程对象
        * */

        Mycallable mycallable = new Mycallable();
        FutureTask<Integer> integerFutureTask = new FutureTask<>(mycallable);
        Thread thread = new Thread(integerFutureTask);
        thread.start();

        Integer integer = integerFutureTask.get();
        System.out.println(integer);
    }
}

class Mycallable implements Callable<Integer> {//表示需要返回一个整数
    @Override
    public Integer call(){
        int sum = 0;
        for (int i = 0; i <= 100; i++) {
            sum += i;
        }
        return sum;
    }
}
