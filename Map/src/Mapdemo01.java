import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Mapdemo01 {
    public static void main(String[] args) {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1,"aaa");
        map.put(2,"bbb");
        map.put(3,"ccc");

        //遍历方式1，通过键找值======================================================
        Set<Integer> integers = map.keySet();
        //创建迭代器
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()){
            int key = iterator.next();
            System.out.println(key + "=" + map.get(key));

        }

        System.out.println("-------------------------------");
        //增强for循环遍历
        for (Integer integer : integers) {
            System.out.println(integer+"="+map.get(integer));
        }

        System.out.println("----------------------------------");
        //lambda表达式循环
        integers.forEach(s-> System.out.println(s+"+"+map.get(s)));
        System.out.println("------------------------------------");

        //遍历方式2.通过键值对对象遍历==================================================
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        //迭代器遍历
        Iterator<Map.Entry<Integer, String>> iterator1 = entries.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        System.out.println("------------------------------------");
        //增强for循环遍历
        for (Map.Entry<Integer, String> entry : entries) {
            int key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key+ "=" +value);
        }

        System.out.println("--------------------------------------");
        //lambda表达式
        entries.forEach(entry-> System.out.println(entry));

        //3.map本身使用lambda遍历=================================================
        System.out.println("-------------------------------------------");
        map.forEach((integer,s)-> System.out.println(integer +"="+ s));
    }
}
