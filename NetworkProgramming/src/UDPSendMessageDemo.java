import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UDPSendMessageDemo {
    /* 使用UDP协议进行信息发送 */
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        //创建DatagramSocket对象（数据报文套接字）
        DatagramSocket datagramSocket = new DatagramSocket();

        while (true) {
            //创建数据报文信息包
            String str = scanner.next();
            byte[] bytes = str.getBytes();
            InetAddress localHost = InetAddress.getLocalHost();//发送到哪个主机
            int port = 10086;//发送到主机上的哪个端口
            DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length, localHost, port);

            //发送数据报文
            datagramSocket.send(datagramPacket);

            if (str.equals("bey")) break;
        }

        //UDP关闭套接字
        datagramSocket.close();
    }
}
