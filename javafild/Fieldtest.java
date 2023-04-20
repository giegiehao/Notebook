package javafild;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

class Student{
    public String sname;
    private int sage;
    protected char ssex;

    public int getsage(){
        return sage;
    }

    public Student(String sname){
        this.sname = sname;
    }

    public Student(String name, int age, char sex){
        this.sname = name;
        this.sage = age;
        this.ssex = sex;
    }

    public String toString(){
        return ("sname="+sname+"\nssex="+ssex+"\n"+getsage());
    }
}


public class Fieldtest {
    public static void main(String[] args) throws Exception{
        Student student1 = new Student("abc");
        Class clazz = Class.forName("javafild.Student");
        Constructor constructor = clazz.getConstructor(String.class, int.class, char.class);
        System.out.println(constructor);
        //获取构造方法

        Field[] fields = clazz.getDeclaredFields();
        System.out.println("----------------------所有字段----------------------");
        for (Field field : fields) {
            System.out.println(field);
        }
        //获得所有字段
        //获得某个字段：getField(字段名)、getDeclaredField(字段名)

        Field f = clazz.getDeclaredField("sage");//得到私有字段
        f.setAccessible(true);//暴力反射，解除私有权限

        //Object obj = constructor.newInstance("objstudentname",18,'男');
        Object obj = clazz.getConstructor(String.class,int.class, char.class).newInstance("name",18,'男');//使用无参构造方法创建对象
        f.set(obj, 20);//abj中的sage set为20
        Student student = (Student)obj;

        System.out.println(student.toString());
}
}
