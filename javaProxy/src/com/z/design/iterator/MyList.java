package com.z.design.iterator;

import java.util.List;

/**
 * User: zhangkb
 * Date: 2019/5/14 0014
 * Time: 下午 4:55
 */
public class MyList<T> implements IList {

    private List<T> list;

    public MyList(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> getIterator() {
        return new MyIterator(list.size());
    }

    private class MyIterator implements Iterator<T> {

        int index;
        int size;
        private MyIterator(int size){
            this.size=size;
        }
        @Override
        public boolean hasNext() {
            return index != size;
        }

        @Override
        public T next() {
            return list.get(index++);


        }
    }
}
