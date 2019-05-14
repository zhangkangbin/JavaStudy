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
public class FatherFilter implements IPersonFilter {
    private IPersonFilter filter;

    public FatherFilter(IPersonFilter filter) {
        this.filter = filter;
    }

    @Override
    public List<Person> doFilter(List<Person> persons) {

        //使用其他过滤器
        List<Person> filterList = filter.doFilter(persons);

        List<Person> personFilter = new ArrayList<>();

        for (Person p : filterList) {
            if (p.getAge() <40) {
                personFilter.add(p);
            }

        }

        return personFilter;
    }
}
