import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPReceiveDemo {
    /* 使用UDP协议接受信息包 */
    public static void main(String[] args) throws IOException {
        //创建UDP套接字对象：接收信息（服务端接收信息并响应）需要指定接收端口
        DatagramSocket datagramSocket = new DatagramSocket(10086);

        //创建信息报以接收信息报
        while (true) {
            byte[] bytes = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);

            Interval interval = new Interval(datagramSocket);
            new Thread(interval).start();

            //接收信息报 线程阻塞以等待接收信息报文
            try {
                datagramSocket.receive(datagramPacket);
            }catch (IOException e){
                break;
            }

            interval.setInterval();

            //解析数据包
            byte[] data = datagramPacket.getData();
            int length = datagramPacket.getLength();
            InetAddress address = datagramPacket.getAddress();
            int port = datagramPacket.getPort();

            System.out.println("原数组中的内容：" + new String(bytes) + "长度为：" + bytes.length);// 可以直接在原本的数组中获取内容
            System.out.println("以接收到数据内容为：" + new String(data) + "长度为：" + length);
            System.out.println("由电脑：" + address + " 的" + port + "端口发出");

        }
        //释放资源
        datagramSocket.close();

        System.out.println("本机电脑ip：" + InetAddress.getLocalHost());
    }
}

class Interval implements Runnable {
        private int interval = 0;
        private DatagramSocket datagramSocket = null;

    public Interval(DatagramSocket datagramSocket) {
        this.datagramSocket = datagramSocket;
    }

    @Override
        public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                interval++;
                if (interval == 120) {
                    //当服务器120秒没有接收到消息后自动关闭服务
                    datagramSocket.close();
                    break;
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        }

        public void  setInterval(){
            this.interval = 0;
        }
}
