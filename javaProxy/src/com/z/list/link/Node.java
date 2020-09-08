package com.z.list.link;

/**
 * User: zhangkb
 * Date: 2019/7/5 0005
 * Time: 上午 9:13
 */
public class Node<T> {

    public Node(T object) {
        this.object = object;
    }

    public T object;
    public Node<T> pre;
    public Node<T> next;

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    public Node<T> getPre() {
        return pre;
    }

    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    public Node<T> getNext() {
        return next;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }




}
