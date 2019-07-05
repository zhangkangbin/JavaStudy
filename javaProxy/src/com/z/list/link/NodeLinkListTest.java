package com.z.list.link;

import java.util.LinkedList;

/**
 * User: zhangkb
 * Date: 2019/7/5 0005
 * Time: 上午 9:28
 *
 * @author zhangkb
 */
public class NodeLinkListTest {

    public static void main(String[] s) {

        NodeLinkList<String> linkList = new NodeLinkList<>();
        linkList.add("A");
        linkList.add("B");
        linkList.add("C");

        linkList.print();

        System.out.println("=========="+ linkList.delete("B"));
        System.out.println("=========="+ linkList.delete("C"));
        System.out.println("=========="+ linkList.delete("A"));
        System.out.println("=========="+ linkList.delete("G"));
        System.out.println("=========="+ linkList.delete("A"));

        linkList.add("D");
        linkList.add("F");
        linkList.add("Z");
        linkList.add("Z");

        System.out.println("=========================="+linkList.getSize());
        linkList.print();
        System.out.println(linkList.findNode("A"));
        System.out.println(linkList.findNode("B"));
        System.out.println(linkList.findNode("C"));


        LinkedList<String> linkedList=new LinkedList<>();

        linkedList.remove("A");


    }
}
