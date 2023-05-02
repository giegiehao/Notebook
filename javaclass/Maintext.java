package javaclass;

import java.lang.reflect.Method;

public class Maintext{
      public static void main(String[] args) throws Exception{
        Class clazz = Class.forName("javaclass.Main");

        Method method = clazz.getMethod("main", String[].class);
        method.invoke(null, (Object)new String[]{});
    }
}

class Main{
  public static void main(String[] args) {
    System.out.println("this is Main.main");
  }
}