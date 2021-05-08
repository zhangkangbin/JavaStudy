package com.z.algorithm;

/**
 * 查找算法
 *
 */
public class SearchTest {

    public static void main(String[] args) {

        int[] array={0,1,2,3,4,5,6,7,8,9};

        binarySearch2(array,-1);
    }

    /**
     * 二分查找算法
     * 元素必须是有序的，如果是无序的则要先进行排序操作。
     * @param array 数组
     * @param key 查找数
     * @return 是否找到
     */
    private static boolean  binarySearch2(int  [] array,int key){

        int size= array.length;

        int low=0;
        int high=size-1;//减一符合数组下标，

        //System.out.println("\n-----二分查找 size------"+size);

            while (low<=high){
                System.out.println("\n-----二分查找-low---high--"+low+"--"+high);

                //数组一分为二。
                int mid=(low+high)/2;

                System.out.println(mid+"-----二分查找-当前中位数-----"+array[mid]);
                //如果key大于中位数,从右边找
                if(array[mid]<key){
                    low=mid+1;

                }
                //如果key小于中位数,从左边找
                else if (array[mid]>key){
                    high=mid-1;
                }else {
                    //todo:找到了
                    System.out.println("\n-----二分查找:找到------"+array[mid]);
                    return true;

                }
            }


        System.out.println("\n-----二分查找:没找到------"+low);
        return false;
    }

}
