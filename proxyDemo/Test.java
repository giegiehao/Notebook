package proxyDemo;

public class Test {
    public static void main(String[] args) {
        ActionImpl action = new ActionImpl("test");

        Action proxyAction = ProxyAction.newProxyAction(action);
        System.out.println(proxyAction.rest(100000));
    }
}
