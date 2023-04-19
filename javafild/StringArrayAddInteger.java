package javafild;

import java.lang.reflect.Method;
import java.util.ArrayList;

public class StringArrayAddInteger {
    public static void main(String[] args) throws Exception{
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("aaa");
        arrayList.add("bbb");
//        arrayList.add(111);报错，不能把int放进去
        Class clazz = arrayList.getClass();
        Method method_add = clazz.getDeclaredMethod("add", Object.class);
        method_add.invoke(arrayList, 111);
        for (Object obj :
                arrayList) {
            System.out.println(obj);
        }
    }
}
