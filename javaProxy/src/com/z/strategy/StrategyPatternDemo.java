package com.z.strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: zhangkb
 * Date: 2019/4/24 0024
 * Time: 上午 9:44
 *
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
