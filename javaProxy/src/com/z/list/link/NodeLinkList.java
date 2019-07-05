package com.z.list.link;

/**
 * User: zhangkb
 * Date: 2019/7/5 0005
 * Time: 上午 9:16
 */
public class NodeLinkList<T> {

    public Node<T> getFirst() {
        return first;
    }


    private Node first;

    public int getSize() {
        return size;
    }

    private int size;

    NodeLinkList() {
        this.first = null;
    }

    public void add(T t) {
        if (first == null) {
            this.first = new Node<>(t);
        } else {
            this.first.setNext(new Node<>(t));
        }

        size++;
    }

    public boolean findNode(T t) {
        if (first == null) return false;

        return first.findNode(t);

    }

    public boolean delete(T t) {

        if (this.first == null) return false;

        if (this.first.getObject().equals(t)) {
            this.first = this.first.getNext();
            size--;
            return true;
        } else {

            if (this.first.getNext() != null) {

                if (this.first.getNext().delete(first, t)) {
                    size--;
                    return true;
                }

            }


        }


        return false;
    }

    public void print() {
        if (first != null) {
            this.first.print();
        }
    }

}
