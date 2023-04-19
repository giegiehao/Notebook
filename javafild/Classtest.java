package javafild;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.util.jar.Attributes.Name;

class A{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public A(){}

    public A(String name, int age){
        this.name = name;
        this.age = age;
    }

    private A(char sex, int age){}
}

public class Classtest{
    public static void main(String[] args) throws Exception{
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

        System.out.println("********某个构造方法*******");
        Constructor oneconstructor = clazz.getConstructor(String.class, int.class);
        System.out.println(oneconstructor);
        //调用构造方法
        oneconstructor.setAccessible(true);//暴力访问：无视修饰符，解除私有限定。
        Object obj = oneconstructor.newInstance("obj",18);//newInstance():使用该constructor代表的构造方法来创建一个该构造方法代表的类的对象，constructor返回值是T类型。
        System.out.println(obj.getClass());
        A obja = (A)obj;
        System.out.println(obja.getName());

    }
}