package spring.advanced.proxy;

import java.lang.reflect.Proxy;

public class HelloClient {

    public static void main(String[] args) {
        Hello proxiedHello = (Hello) Proxy.newProxyInstance(
                HelloClient.class.getClassLoader()
                , new Class[]{Hello.class}
                , new UppercaseHandler(new HelloTarget())
        );

        System.out.println(proxiedHello.sayHello("hanna"));
        System.out.println(proxiedHello.sayHi("hanna"));
        System.out.println(proxiedHello.sayThankYou("hanna"));
    }
}
