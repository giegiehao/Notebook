import java.util.HashMap;
import java.util.Map;

/**
 * 可变参数
 * 1.可变参数的本质就是数组
 * 2.作用：可变参数用来接收多个参数
 * 3.格式：参数类型...参数名
 * 4.注意事项
 *  - 可变参数在一个方法中只能存在一个
 *  - 可变参数必须放在参数列表最后
 */
public class ArgsDemo {
    public static void main(String[] args) {
        int addsum = addsum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(addsum);
    }

    private static int addsum(int...nums) {
        int sum = 0;
        for (int i : nums) {
            sum+= i;
        }
        Map<Character, Integer> objectObjectMap = new HashMap<>();
        Map<Character, Integer> map = new HashMap<>();
        objectObjectMap.put('I', 1);
        char I = 'I';
        System.out.println(objectObjectMap.get(I));
        return sum;
    }
}
