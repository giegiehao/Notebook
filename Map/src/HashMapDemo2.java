import java.util.*;

public class HashMapDemo2 {
    public static void main(String[] args) {
        //100个同学偷投票A、B、C、D四个景点
        //记录每个景点的得票数并输出票数最多的景点

        //定义一个数组，保存四个景点
        String[] strs = {"A","B","C","D"};
        //模拟学生投票纪录
        ArrayList<String> arr = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            int index = random.nextInt(strs.length);
            arr.add(strs[index]);
        }
//        System.out.println(arr);

        //计算投票各景点总数
        HashMap<String, Integer> map = new HashMap<>();
        for (String name : arr) {
            if (map.containsKey(name)) {
                //如果map中已保存过这个景点，则把票数拿出来加一再更新到map里
                int index = map.get(name);
                index++;
                map.replace(name, index);
            }else {
                //如果这是一个新的景点，则把这个景点记录下来
                map.put(name, 1);
            }
        }
        System.out.println(map);

        //计算票数最大值
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        int max = 0;
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() > max){
                max = entry.getValue();
            }
        }

        //找出票数最多的景点
        System.out.println("票数最多的景点是：");
        for (Map.Entry<String, Integer> entry : entries) {
            if (entry.getValue() == max){
                System.out.println(entry.getKey());
            }
        }
    }
}
