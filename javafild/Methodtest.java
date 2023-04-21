package javafild;

import java.lang.reflect.Method;

class StudentMothod{
    public String method1(){
        return "method1";
    }

    protected void method2(){

    }

    private String method3(){
        System.out.println("被调用了");
        return "method3";
    }
}

public class Methodtest {
    public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("javafild.StudentMothod");
        
        System.out.println("获取所有方法");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method);
        }

        System.out.println("获取公有方法");
        Method[] methods2 = clazz.getMethods();
        for (Method method : methods2) {
            System.out.println(method);
        }
        //获取到的公有方法比类定义的所有方法要多

        Method method = clazz.getDeclaredMethod("method3", null);//第一个参数是方法名，第二个是方法的形参；
        method.setAccessible(true);
        
        Object obj = clazz.getDeclaredConstructor().newInstance();//在没有定义构造函数时，默认的无参构造方法的权限限制符与该类的相同，在这里是默认的defoult;
        System.out.println(method.invoke(obj,null));

        StudentMothod studentMothod = new StudentMothod();
        System.out.println(studentMothod.method1().hashCode());
//        System.out.println(method == studentMothod.method1());

        Method method1 = clazz.getMethod("method1",null);
        System.out.println(method1.hashCode() == studentMothod.method1().hashCode());
        System.out.println(method1.hashCode());
        System.out.println(studentMothod.method1().hashCode());

    }
}
