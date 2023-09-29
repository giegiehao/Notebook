import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

public class Stopwatch {
    public static void main(String[] args) throws IOException, InterruptedException {
        File file = new File("time");
        if (!file.exists()){
            boolean newFile = file.createNewFile();
        }
        FileWriter fileWriter = new FileWriter(file);

        int i = 1;
        while (true) {
            Thread.sleep(1000);
//            fileWriter.write(i + "\r\n");
           fileWriter.write(i);
            fileWriter.flush();
            i++;
        }
    }
}
