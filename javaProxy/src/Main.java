import com.z.proxy.*;

import java.lang.reflect.Proxy;

/**
 * @author zhangkb
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("------------静态代理------------");
        //静态代理
        IUser myProxy = new MyProxy(new My());
        myProxy.findGirl();


        System.out.println("------------动态代理------------");

       //动态代理
        IUser my = new My();
        IUser proxySubject = (IUser) Proxy.newProxyInstance(IUser.class.getClassLoader(),
                new Class[]{IUser.class},
                new MyProxyHandler<>(my));
        proxySubject.findGirl();


        System.out.println("------------匿名代理------------");

        ProxyUtil<IUser> proxyUtil=new ProxyUtil<>();
        proxyUtil.getProxy(IUser.class,new My()).findGirl();

    }

}
