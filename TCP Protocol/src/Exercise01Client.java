import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 多发多收
 * 客户端：多次发送数据
 * 服务端：多次接收数据，并打印
 */
public class Exercise01Client {
    // 客户端
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        //创建套接字对象
        Socket socket = new Socket("127.0.0.1", 10086);

        //创建IO流
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        //实现多次发送功能
        while (true){
            String massage = scanner.nextLine();
            bufferedWriter.write(massage + "\n");
            bufferedWriter.flush();
            if ("886".equals(massage)) break;

            //接收反馈信息
            String feedback;
            if ((feedback = bufferedReader.readLine()) != null) System.out.println(feedback);
            else System.out.println("发送失败");
        }

        //回收资源
        socket.close();
    }
}
