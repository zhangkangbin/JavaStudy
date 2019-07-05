package com.z.list.link;

/**
 * User: zhangkb
 * Date: 2019/7/5 0005
 * Time: 上午 9:13
 */
public class Node<T> {
    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }

    private T object;
    private Node next;

    public Node(T object) {
        this.object = object;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        if (this.next == null) {
            this.next = next;
            //    System.out.println(next.object + "\t--");
        } else {
            //    System.out.println(next.object + "\t");
            this.next.setNext(next);
        }
    }


    public boolean findNode(T t) {
        if (t.equals(object)) {
            return true;
        } else {
            if (next != null) {
                return next.findNode(t);
            }
            return false;
        }
    }

    public boolean delete(Node<T> root, T data) {
        //如果当前节点等于 data

        if (data.equals(object)) {
            System.out.println(this.object + "--delete-\t");
            //  System.out.println(this.next.object + "---\t");
            //把root的 next 调整成当前object 的next.
            root.next = this.next;
            return true;
        } else {
            if (this.next != null) {
                return this.next.delete(this, data);
            }

            return false;
        }

    }

    public void print() {
        System.out.println(this.object + "\t");
        // 还有下一个元素，需要继续输出
        if (this.next != null) {
            // 下一个节点继续调用print
            this.next.print();
        }

    }
}
