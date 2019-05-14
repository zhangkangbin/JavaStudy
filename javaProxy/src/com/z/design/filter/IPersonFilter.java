package com.z.design.filter;

import java.util.List;

/**
 * User: zhangkb
 * Date: 2019/5/14 0014
 * Time: 上午 10:54
 * @author zhangkb
 */
public interface IPersonFilter {
    List<Person>   doFilter(List<Person> persons);
}
