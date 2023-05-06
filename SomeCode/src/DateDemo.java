import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class DateDemo {
    public static void main(String[] args) {
        //创建日历对象
        LocalDateTime ldt = LocalDateTime.now();//标准时间
        System.out.println(ldt);

        //System.out.println(ZoneId.getAvailableZoneIds());//展示时区

        //获得其它时区时间
        LocalDateTime zoneldt = LocalDateTime.now(ZoneId.of("America/Asuncion"));
        System.out.println(zoneldt);

        //设置时间样式对象
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy年 MM月 dd日 HH时 mm分 ss秒 EE a");
        System.out.println(zoneldt.format(formatter));
    }
}
