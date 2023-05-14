import java.util.Iterator;
import java.util.TreeSet;

public class A01_TreeSet_1 {
    //TreeSet可排序、无重复、无索引
    //TreeSet中存放对象时，该对象需要实现Comparable接口
    public static void main(String[] args) {
        //创建学生对象
        Student student = new Student("zhansan", 18);
        Student student1 = new Student("lisi",19);
        Student student2 = new Student("wanwu",20);
        Student student3 = new Student("zhaoliu",18);
        Student student4 = new Student("zhansan",21);

        //Treeset对象，存放student对象
        TreeSet<Student> ts = new TreeSet<>();
        System.out.println(ts.add(student));//true
        ts.add(student1);
        ts.add(student2);
        System.out.println(ts.add(student3));//false
        System.out.println(ts.add(student4));//true
        //同为18岁的学生不会被添加到ts中，因为如果以age作为排列标准，相当于age不可重复
        //而name就可以重复

//        System.out.println(ts);
        Iterator<Student> iterable = ts.iterator();
        while (iterable.hasNext()){
            System.out.println(iterable.next());
        }
        
    }
}
