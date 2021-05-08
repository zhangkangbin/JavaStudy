package com.z.algorithm;

/**
 * 查找算法
 *
 */
public class SearchTest {

    public static void main(String[] args) {

        int[] array={0,1,2,4,5,6,7,8,9};

        binarySearch2(array,-2);

        int size=array.length;
        recursionBinarySearch2(array,-3,0,size-1);
        recursionBinarySearch2(array,10,0,size-1);
        recursionBinarySearch2(array,3,0,size-1);

        recursionBinarySearch2(array,0,0,size-1);
        recursionBinarySearch2(array,5,0,size-1);
        recursionBinarySearch2(array,9,0,size-1);

    }
    /**
     * 二分查找算法,递归版
     * 元素必须是有序的，如果是无序的则要先进行排序操作。
     * @param array 数组
     * @param key 查找数
     * @return 是否找到
     */
    private static boolean  recursionBinarySearch2(int  [] array,int key,int low,int high){


        System.out.printf("\n-----二分查找---low:%s  high:%s \n",low,high);
        //前排判断是否小于数组的最小数，大于最大数。不存在中间里面 low>high，会像 3:2。
        if(key < array[low] || key > array[high]||low>high){
            System.out.println("-----------------------------没有找到----："+key);
            return false;
        }

        int mid=(low+high)/2;
        System.out.println("-----mid----:"+mid);

        //往右
        if(key>array[mid]){
            low=mid+1;
            //开始套娃
           return recursionBinarySearch2(array,key,low,high);
        }else if (key<array[mid]){
            //往左
            high=mid-1;
            //套娃
            return recursionBinarySearch2(array,key,low,high);
        }else {
            System.out.println("-------------------------找到数值----:"+array[mid]);
            return true;
        }

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
                System.out.printf("\n-----二分查找-low:%s  high:%s \n",low,high);

                //数组一分为二。
                int mid=(low+high)/2;

                System.out.println(mid+"-----二分查找-当前中位数-----:"+array[mid]);
                //如果key大于中位数,从右边找
                if(array[mid]<key){
                    low=mid+1;

                }
                //如果key小于中位数,从左边找
                else if (array[mid]>key){
                    high=mid-1;
                }else {
                    //todo:找到了
                    System.out.println("\n-----二分查找:找到------:"+array[mid]);
                    return true;

                }
            }


        System.out.printf("\n-----二分查找:没找到---low:%s  high:%s \n",low,high);
        return false;
    }



}
