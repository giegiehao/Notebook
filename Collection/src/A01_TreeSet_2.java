import java.util.Comparator;
import java.util.TreeSet;

public class A01_TreeSet_2 {
    public static void main(String[] args) {
        //生成person对象
        Person person = new Person("zhansan",18);
        Person person1 = new Person("lisi",19);
        Person person2 = new Person("zhaoliu",20);

        //创建treeset对象，并传入 comparable对象,设置排序方式
        TreeSet<Person> ts = new TreeSet<>((o1, o2) -> {
            //o1为需要放入的元素，o2为treeset中已经存放的元素
            return o1.getAge() - o2.getAge();
        });

        ts.add(person1);
        ts.add(person);
        ts.add(person2);
        System.out.println(ts);


        //自定义string排列方法
        String[] stringss = {"abc", "ac", "bc", "aaa", "q"};
        TreeSet<String> strings = new TreeSet<>((o1, o2) -> {
            int i = o1.length() - o2.length();
            i = i == 0? o1.compareTo(o2) : i;
            return i;
        });
        for (String s : stringss) {
            strings.add(s);
        }

        System.out.println(strings);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
