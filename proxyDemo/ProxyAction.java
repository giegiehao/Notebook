package proxyDemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyAction {
    public static Action newProxyAction(ActionImpl action) {
        Action a = (Action) Proxy.newProxyInstance(ProxyAction.class.getClassLoader(),
                new Class[]{Action.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        long before = System.currentTimeMillis();

                        System.out.println(method.invoke(action, args));

                        long after = System.currentTimeMillis();
                        return ("运行时间" + (after - before) + "毫秒");
                    }
                });
        return a;
    }
}
