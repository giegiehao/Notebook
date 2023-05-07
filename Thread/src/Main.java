import java.rmi.Naming;

public class Main {
        public static void main(String[] args) throws InterruptedException {
            TicketHouse house = new TicketHouse();
            // ming线程
            Thread ming = new Thread(house);
            ming.setName("ming");
            // hong线程
            Thread hong = new Thread(house);
            hong.setName("hong");
            // 开始买票
            ming.start();
            hong.start();
        }
    }

    class TicketHouse implements Runnable {

        int fiveMount = 2;
        int twentyMount = 0;


        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            if(name.equals("ming")){
                saleTicket(20);
            } else if (name.equals("hong")) {
                saleTicket(5);
            }
        }

        public synchronized void saleTicket(int money) {
            // money为5， 直接购票成功
            if(money == 5){
                fiveMount+=1;
                System.out.println(Thread.currentThread().getName() + "购票成功");
            } else if (money == 20) {
                // money为20， 需要判断零钱是否足够
                twentyMount+=1;
                // 使用while，以确保线程在等待时或者被唤醒时会再次检查条件
                while (fiveMount < 3){
                    System.out.println("零钱不够," + Thread.currentThread().getName()+ "在旁边等");
                    try {
                        wait(); // 线程被卡在这个位置
                        System.out.println(Thread.currentThread().getName() + "被激活了");
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                fiveMount -= 3;
                System.out.println(Thread.currentThread().getName() + "买票成功，付钱20，找零3张5元");
            }
            // 这一步每次有人来买票都会运行
            // 激活所有等待该方法的线程
            notifyAll();
        }
    }