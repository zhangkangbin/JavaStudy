package com.z.algorithm;

/**
 * 查找算法
 *
 */
public class SearchTest {

    public static void main(String[] args) {

        int[] array={1,2,5,6,8,9};

        binarySearch2(array,1);

    }

    /**
     * 二分查找算法
     * 元素必须是有序的，如果是无序的则要先进行排序操作。
     * @param array
     * @param key
     * @return
     */
    private static boolean  binarySearch2(int  [] array,int key){

        int size= array.length;

        int low=0;
        int high=size-1;

        //System.out.println("\n-----二分查找 size------"+size);

        for(int i=0;i<size;i++){

            System.out.println("\n-----二分查找-low---high--"+low+"--"+high);

            //数组一分为二。
            int mid=(low+high)/2;

            System.out.println("-----二分查找-当前中位数-----"+array[mid]);
            //如果key大于中位数,从右边找
            if(array[mid]<key){
                low=mid+1;

            }
            //如果key小于中位数,从左边找
            else if (array[mid]>key){
                high=mid-1;
            }else {
                //找到了
                // return array[mid];
                System.out.println("\n-----二分查找:找到------"+array[mid]);
                return true;

            }


        }

        System.out.println("\n-----二分查找:没找到------");
        return false;
    }

}
