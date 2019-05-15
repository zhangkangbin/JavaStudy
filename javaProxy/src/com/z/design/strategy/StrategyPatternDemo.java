package com.z.design.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * Date: 2019/4/24 0024
 * Time: 上午 9:44
 *在策略模式（Strategy Pattern）中，一个类的行为或其算法可以在运行时更改。这种类型的设计模式属于行为型模式。
 * 在策略模式中，我们创建表示各种策略的对象和一个行为随着策略对象改变而改变的 context 对象。策略对象改变 context 对象的执行算法
 *
 * 优点： 1、算法可以自由切换。 2、避免使用多重条件判断。 3、扩展性良好。
 * 缺点： 1、策略类会增多。 2、所有策略类都需要对外暴露。
 * @author zhangkb
 */
public class StrategyPatternDemo {
    private static Map<Integer, Eat> map = new HashMap<>();

    // 字典结合策略模式简化代码
    static {
        put(new EatFruits());
        put(new EatMeat());
    }

    public static void main(String[] args) {

        //避免写 if else
        Eat eat = map.get(1);
        if (eat == null) {
            return;
        }
        //细分业务
        eat.setAction("pear");
        Context context = new Context(eat);
        context.doSomething();
    }

    private static void put(Eat eat) {
        map.put(eat.getType(), eat);
    }
}
