package javaclass;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class StringArrayAddInteger {
    public static void main(String[] args) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
//        int a =new Integer(1);
//        System.out.println("a:"+ a);
//        Object a1 = a;
//        System.out.println(a1);
//        arrayList.add(111);报错，不能把int放进去
        Class clazz = arrayList.getClass();
//        System.out.println(clazz.);\

        Object obj1 =clazz;
        Object obj2 = new Object();
//        Class class22 = new Class();
//        obj2.equals()
//        Class cobj2 = (Class)obj2;
        System.out.println("class.super:"+clazz.getSuperclass());

//        Class class_c = Class.forName("java.lang.Class");
//        Constructor constructor = class_c.getDeclaredConstructor(ClassLoader.class,Class.class);
//        System.out.println(constructor);
//        constructor.setAccessible(true);
//        Object class_d = constructor.newInstance(null,null);
//        事实证明，我想使用反射Class的构造方法（私有），从而去实例一个Class对象是不行的。

        System.out.println("obj2:"+obj2.getClass());
//        System.out.println(cobj2.getClass());
        System.out.println("obj1:"+obj1.getClass());
        System.out.println("clazz:"+clazz.getClass());
        Method method_add = clazz.getDeclaredMethod("add", Object.class);
        method_add.invoke(arrayList, 111);
        for (Object obj :
                arrayList) {
            System.out.println(obj);
        }
    }
}
