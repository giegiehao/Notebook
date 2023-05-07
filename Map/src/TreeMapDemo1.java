import java.util.Comparator;
import java.util.TreeMap;

public class TreeMapDemo1 {
    /*
    TreeMap基本应用 需求1：
    键：整数表示id
    值：字符串表示商品名称
    要求：按照id的升序排列、按照id的降序排列
    */

    public static void main(String[] args) {
        //创建TreeMap对象
//        TreeMap<Integer, String> treeMap = new TreeMap<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                int i = o1 - o2;
//                return i;
//            }
//        });

        TreeMap<Integer, String> treeMap = new TreeMap<>(Comparator.comparingInt(o -> o));

        //添加商品内容
        treeMap.put(2,"牙刷");
        treeMap.put(1,"水杯");
        treeMap.put(5,"毛巾");

        System.out.println(treeMap);
    }
}
