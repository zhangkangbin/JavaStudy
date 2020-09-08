package com.z.list.link;

import java.util.LinkedList;

/**
 * User: zhangkb
 * Date: 2019/7/5 0005
 * Time: 上午 9:28
 *
 * 单链表实现
 * @author zhangkb
 */
public class NodeLinkListTest {

    public static void main(String[] s) {

/*        NodeLinkList<DataBean> linkList = new NodeLinkList<>();

        DataBean dataBean1=new DataBean("1xiao","11");
        DataBean dataBean2=new DataBean("2zhang","22");
        DataBean dataBean3=new DataBean("3jiajia","33");
        linkList.add(dataBean1);
        linkList.add(dataBean2);
        linkList.add(dataBean3);


        linkList.toString();

        System.out.println("=========="+ linkList.find(dataBean2).object.age);
        System.out.println("=========="+ linkList.delete(dataBean2));


        linkList.toString();*/

        NodeLinkList<String> linkList = new NodeLinkList<>();


        linkList.add("1");
        linkList.add("2");
        linkList.add("3");
        linkList.add("4");
        linkList.add("5");

        linkList.toString();

        linkList.delete("4");

        linkList.toString();

    }
}
