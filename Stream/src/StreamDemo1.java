import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo1 {
    /*
    stream流中有两种类型的方法，一种为中间方法，即对数据进行加工的，比如filter，skip，limit等
    一种为终结方法，即对数据进行输出或者保存，比如foreach，collect等
    中间方法之后是可以使用流方法的
    终结方法之后不可以再使用流方法，因为方法不返回流，无法再进行流操作。
    */

    public static void main(String[] args) {
        //1.定义一个集合，并添加一些整数
        //过滤奇数，只留下偶数
        //并将结果保存下来

        //定义集合并批量添加数据
        ArrayList<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        //使用stream流对数据进行处理
        List<Integer> list1 = list.stream().filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(list1);

        /*2.创建一个集合，并添加以下字符串，字符串中前面是姓名，后面是年龄
        * “zhangsan，23”
        * “lisi，24”
        * “wangwu，25”
        * 保留年龄大于等于24的人，并将结果收集到map集合中，姓名为键，年龄为值*/

        ArrayList<String> list2 = new ArrayList<>();
        //批量添加数据
        Collections.addAll(list2,"zhangsan，23","lisi，24","wangwu，25");
        //stream处理数据
        List<String> stringList = list2.stream().filter(s -> Integer.parseInt(s.split("，")[1]) >= 24)
                .collect(Collectors.toList());
        System.out.println(stringList);

    }
}