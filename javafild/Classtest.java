package javafild;
import java.lang.reflect.Constructor;
import java.util.jar.Attributes.Name;

class A{
    private String name;
    private int age;

    public A(){}

    public A(String name, int age){
        this.name = name;
        this.age = age;
    }

    private A(char sex, int age){}
}

public class Classtest{
    public static void main(String[] args) throws ClassNotFoundException {
        A a = new A("name",18);
        System.out.println(a.getClass());
        Class clazz = Class.forName("javafild.A");
        System.out.println(clazz);
        System.out.println(clazz.equals(a.getClass()));

        System.out.println("***************所有公有构造方法***********");
        Constructor[] conArray = clazz.getConstructors();
        for (Constructor constructor : conArray) {
            System.out.println(constructor);
        }

        System.out.println("*************所有构造方法*********");
        Constructor[] conArrayall = clazz.getDeclaredConstructors();
        for (Constructor constructor2 : conArrayall) {
            System.out.println(constructor2);
        }
    }
}