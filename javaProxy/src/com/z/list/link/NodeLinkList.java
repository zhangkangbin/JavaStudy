package com.z.list.link;

/**
 * User: zhangkb
 * Date: 2019/7/5 0005
 * Time: 上午 9:16
 */
public class NodeLinkList<T> {

    private Node<T> mFirst;
    private Node<T> mLast;



    public void  add(T data){

        Node<T> node=new Node<>(data);

        if(mFirst==null){
            mFirst=node;
        }else {
            mLast.next=node;
            mLast.next.pre=mLast;
        }

        mLast=node;
    }


    public boolean delete(T data){

        final Node<T> node = find(data);


        if(node==null){
            return  false;
        }

        final Node<T> nodePre = node.pre;
        final Node<T> nodeNext = node.next;


        if(nodePre==null){
            //第一个 // null-1-2 变成  1-2-3
            mFirst=nodeNext;
        }else {
            node.pre.next=nodeNext;
            node.pre=null;
        }


        if(nodeNext==null){

            mLast=nodePre;

        }else {

            //把下一个的next的pre,修改成上一个
            //如果是第一个这个pre(即nodePre==null情况)为null ,1 2 3 修改为 null-2-3
            node.next.pre=nodePre;
            node.next=null;
        }


        return true;

    }

    public Node<T>  find(T data){


        if(mFirst==null){
            return null;
        }

        if(mFirst.object.equals(data)){


            return mFirst;
        }


        if(mLast!=null&&mLast.object.equals(data)){

            return mLast;
        }


        Node<T> node = mFirst.next;
        while (node!=null){

            if(node.object.equals(data)){

                return node;
            }
            node=mFirst.next;
        }

        return  null;
    }


    @Override
    public String toString() {

        StringBuilder stringBuilder=new StringBuilder();

        Node<T> node=mFirst;
        while (node!=null){

            if(node.pre!=null){
                stringBuilder.append(node.pre.object+"-");
            }else {
                stringBuilder.append("null-");
            }
            stringBuilder.append(node.object+"-");

            if(node.next!=null){
                stringBuilder.append(node.next.object+"   ");
            }else {
                stringBuilder.append("null    ");
            }
            node=node.next;
        }


        System.out.println(stringBuilder.toString());
        return stringBuilder.toString();
    }
}
