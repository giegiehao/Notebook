package Logtest;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LogTest {

    public static void main(String[] args) {
       Logger logger = Logger.getLogger("Logtest.LogTest");

       try {
           FileHandler fileHandler = new FileHandler("Logtest/log.log");// JDK Logging 提供的一个文件处理器
//           可以把日志输出到指定的文件中，默认的是ConsoleHandler（控制台处理器），还可以经过网络输出：sockerhandler
           logger.addHandler(fileHandler);
           logger.setUseParentHandlers(false);
       }catch (IOException e) {
           throw new RuntimeException();
       }

       logger.info("this is info");

        try {
            int[] ints = new int[2];
            for (int i = 0; i < 3; i++) {
                ints[i] = i;
            }
        }catch(Exception e){
            logger.log(Level.INFO,"数组越界了",e);
        }
    }
}
