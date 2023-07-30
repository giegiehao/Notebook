import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Exercise01Server {
    //服务端
    public static void main(String[] args) throws IOException {
        //创建服务端套接字
        ServerSocket serverSocket = new ServerSocket(10086);

        //等待客户端连接,并建立连接
        while (true){
            Socket socket = serverSocket.accept();
            System.out.println("已创建连接");

            //创建I流
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //创建O流：发出反馈消息
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //多次接收信息
            String massage;
            try {
                while ((massage = bufferedReader.readLine()) != null) {
                    System.out.println("接收到信息：");
                    System.out.println(massage);

                    //收到信息后发送反馈给客户端
                    bufferedWriter.write("已发送\n");
                    bufferedWriter.flush();
                }
            }catch (SocketException e) {
                System.out.println("连接异常中断");
            } finally {
                System.out.println("正在尝试重新连接");
            }
        }
//            socket.close();
//            System.out.println("客户端关闭连接");


    }
}
