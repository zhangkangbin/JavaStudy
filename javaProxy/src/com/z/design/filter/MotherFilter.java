package com.z.design.filter;

import java.util.ArrayList;
import java.util.List;

/**
 * User: zhangkb
 * Date: 2019/5/14 0014
 * Time: 上午 11:02
 *
 * @author zhangkb
 */
public class MotherFilter implements IPersonFilter {
    @Override
    public List<Person> doFilter(List<Person> persons) {
        List<Person> personFilter = new ArrayList<>();
        for (Person p : persons) {

            if (p.getAge() > 18) {
                personFilter.add(p);
            }

        }

        return personFilter;
    }
}
