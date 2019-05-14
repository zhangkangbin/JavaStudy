package com.z.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangkb
 * Date: 2019/5/14 0014
 * Time: 上午 10:56
 *
 * @author zhangkb
 */
public class MyFilter implements IPersonFilter {
    @Override
    public List<Person> doFilter(List<Person> persons) {
        List<Person> personFilter = new ArrayList<>();
        for (Person p : persons) {
            //过滤没有结婚的
            if (!p.isMarital()) {
                personFilter.add(p);
            }

        }

        return personFilter;
    }
}
