package com.z.algorithm;


import java.util.Arrays;

/**
 * User: zhangkb
 * Date: 2020/9/21 0010
 * Time: 上午 9:41
 *排序算法
 * @author zhangkb
 */
public class AlgorithmTest {


    public static void mergeSort(int[] sourceArray,int low,int high){

        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = sourceArray;
        int length=arr.length;

        if (length < 2) {
          printArray(arr);
        }

        int middle = (low+high)/2;

        int[] left = new int[middle];
        int[] right = new int[high-middle];

        //int[] arrayx=new int[10];




       //return merge( mergeSort(left), mergeSort(right));

    }

    private static int[]  merge(int[] left,int[] right){


        int[] result = new int[left.length + right.length];
        int i = 0;

        while (left.length > 0 && right.length > 0) {
            if (left[0] <= right[0]) {
                result[i++] = left[0];
                left = Arrays.copyOfRange(left, 1, left.length);
            } else {
                result[i++] = right[0];
                right = Arrays.copyOfRange(right, 1, right.length);
            }
        }

        while (left.length > 0) {
            result[i++] = left[0];
            left = Arrays.copyOfRange(left, 1, left.length);
        }

        while (right.length > 0) {
            result[i++] = right[0];
            right = Arrays.copyOfRange(right, 1, right.length);
        }

        return result;
    }


    /**
     * 冒泡
     * @param a
     */
    public static void bubbleSort123(int[] a) {
        int temp;
        int size = a.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {


                System.out.print(i+ " --"+j);
                //大于
                if (a[j] > a[j + 1]) {
                    //保存二个比较中，最大的数值
                    temp = a[j];
                    //   System.out.println(temp);
                    //交换双方位置
                    // 数值小的数往前挪
                    a[j] = a[j + 1];
                    // 数值大的数往后挪
                    a[j + 1] = temp;



                    System.out.println(" ");
                } else {
            /*       for (int aSort : a) {
                        System.out.print(aSort + " ,");
                    }
                    System.out.println(" ");*/
                }
            }

        }
    }


    /**
     * 插入排序
     * @param array
     */
    static void  insertSort(int[] array){

        array = new int[]{5,1,4,2};

        int length=array.length;
        int current,preIndex;
        for(int i=1;i<length;i++){

            preIndex=i-1;

            current=array[i];

            //  {5,1,2,4,6};
            while (preIndex>=0&&array[preIndex]>current){


                System.out.println("---:"+array[preIndex]+">"+current);
           //     System.out.println("---"+current);

                //交换值
                array[preIndex+1]=array[preIndex];

                preIndex--;
                printArray(array);
            }
          //  printArray(array);
            System.out.println("\npreIndex---:"+preIndex);
            array[preIndex+1]=current;


            printArray(array);
        }



    }


    /**
     * 选择排序
     * @param array 数组
     */
    static void  selectionSort(int[] array){


      //  int[] array = {1,5,7, 6, 2};


        int size=array.length;
        int minIndex=0;

        int temp;
        /*
         * 把最小的放前面
         */
        for(int i=0;i<size-1;i++){

            //当前最小的数下标,也用于下一轮minIndex重置
            minIndex = i;

            // int[] sort = {8,5,7, 6, 2};

            for(int j=i+1;j<size;j++){
           //    System.out.print(j);
                //比较那个更小
           // System.out.println("------比较那个更小 for ： "+array[j]+"<"+array[minIndex]);
                System.out.println("------比较那个更小 for ： "+array[j]+"<"+array[minIndex]);
                if(array[j]<array[minIndex]){
                   System.out.println("------选择排序 minIndex ： "+array[j]);
                    minIndex=j;
                }
            }

            System.out.println("选择排序 交换位置： "+i);
            System.out.println("----------选择排序 最小数： "+array[minIndex]);
            //每一轮对比完成，交换位置。
            temp=array[i];
            array[i]=array[minIndex];
            array[minIndex]=temp;




           printArray(array);
           // System.out.print("选择排序 ");
        }
   //     System.out.print("选择排序 ");

 //    printArray(array);

    }

    /**
     * 冒泡
     * @param array
     * @return
     */
    static int[] bubbleSort(int[] array){

        int temp;
        int size=array.length;
        for(int i=1;i<size;i++){

            for(int j=0;j<size-i;j++){
                if(array[j]>array[j+1]){

                    //保存二个比较中，最大的数值
                    temp=array[j];

                    //往后挪(实是为了交互双方位置)
                    array[j]=array[j+1];
                    //往前挪
                    array[j+1]=temp;

                }



            }




        }


        printArray(array);


        return array;
    }


    private static void printArray(int[] sort){
        for (int aSort : sort) {
            System.out.print(aSort + " ,");
        }
        System.out.println( "");
    }
    public static void main(String[] args) {

        int[] sort = {1,5,4,3,6};
       // int[] sort = {5,2};
       // int[] sort = {5,2,2};

       // bubbleSort(sort);
/*
        System.out.println("\n------冒泡排序-----");
        bubbleSort(sort);
*/

        System.out.println("\n-----选择排序------");
       // selectionSort(sort);
      //  aaa(sort);

        insertSort(sort);

    /*    int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        binarySearch2(array,13);*/
      //  binarySearch2(array,1);

    }



    private static int  binarySearch2(int  [] array,int key){

        int size= array.length;

        int low=0;
        int high=size-1;
   //     System.out.println("\n-----二分查找 size------"+size);

        for(int i=0;i<size;i++){

            System.out.println("\n-----二分查找-low---high--"+low+"--"+high);

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

                return array[mid];
            }


        }

        System.out.println("\n-----二分查找:没找到------");
        return 0;
    }
}
