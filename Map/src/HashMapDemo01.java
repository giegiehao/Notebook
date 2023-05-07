import java.util.HashMap;
import java.util.Objects;

public class HashMapDemo01 {
    public static void main(String[] args) {
        HashMap<Student,String> hashMap = new HashMap<>();

        //创建学生对象
        Student student = new Student("zhansan", 24);
        Student student1 = new Student("lisi", 23);
        Student student2 = new Student("wanwu", 25);
        //添加一个相同的学生
        Student student3 = new Student("lisi", 23);

        //添加元素
        hashMap.put(student,"广东");
        hashMap.put(student1,"四川");
        hashMap.put(student2,"广西");
        hashMap.put(student3,"福建");//原本四川的值被覆盖

        //遍历
        hashMap.forEach((stu,s)-> System.out.println(stu + "籍贯："+ s));

    }
}

class Student{
    private String name;
    private int age;

    public Student(String name, int age) {
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
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
