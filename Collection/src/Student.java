import java.util.Objects;

public class Student implements Comparable<Student>{
    private String name;
    private int age;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Student student = (Student) o;
//        return age == student.age && Objects.equals(name, student.name);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(name, age);
//    }

    @Override
    public int compareTo(Student o) {//根据返回值的正负确定该元素放在红黑树的哪个位置
        return this.getAge() - o.getAge();//o是已经在红黑树中的元素
    }
}
