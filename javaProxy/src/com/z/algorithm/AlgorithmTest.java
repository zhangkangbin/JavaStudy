package com.z.algorithm;


import java.util.Arrays;

/**
 * User: zhangkb
 * Date: 2020/9/21 0010
 * Time: 上午 9:41
 *排序算法
 * @author zhangkb
 * 算法gif图片,比较直观。
 * https://blog.csdn.net/csdn_baotai/article/details/80293679#comments_15536540
 *
 * 排序的概念与分类
 * 直接插入排序（已完成），希尔排序，基数排序。
 *
 * 哈希表的构造
 * 哈希表的实现
 *
 * 递归。
 * 递归函数的执行过程
 * 折半查找 （已完成）
 *
 *
 * 归并排序，快速排序。
 * 广义表定义（是一种非连续性的数据结构，是线性表的一种推广。），存储与实现。
 *
 * 二叉树
 * 二叉树的实现，包括顺序和链式存储结构
 * 二叉树的遍历
 * 堆和堆排序
 * 二叉树排序树
 * 二叉平衡树。
 *
 * 树和森林
 *并查集
 *拓扑排序
 *
 */
public class AlgorithmTest {





    /**
     * 插入排序
     * 简单来说就是往排好序的列表插入一个数，继续对比排序（这个过程类似冒泡）
     */
    static void  insertSort(){

        int[] array = new int[]{4,5,2,1};

        int length=array.length;
        //当前的值，用于比较，和后面的赋值。
        int current;
        //前一个的下标
        int preIndex;
        for(int i=1;i<length;i++){

            //前面
            preIndex=i-1;
         //   System.out.println("\n----------preIndex---:"+(preIndex));
            //当前i的值
            current=array[i];

            //{9,3,1,6};

            /*
            preIndex>=0，这个数会往后。如果往前，是为了比较前面的数字是否比它小，主要是做检查。
            如果为负数就跳出循环。为负数情况是比较都最前面那个数字了。
            array[preIndex]>current 满足前面大于后面的，把前面的值赋值成后面的值。否则继续往后挪比较。
             */
            while (preIndex>=0&&array[preIndex]>current){

              //  System.out.println("---:"+array[preIndex]+">"+current);

                //赋值, 比如 9,3,1,2 ，就会变成  9 ，9 ，1 ，2，，这里 9 ,9重复了，注意：下面会重新赋值。
                array[preIndex+1]=array[preIndex];

                //--就是前面那位。主要为了检查，检查前面的数字是否比它大。提示：如果0 --就是负一。就会跳出循环
                preIndex--;
             //   System.out.println("\npreIndex---:"+(preIndex));

                printArray(array);

            }
            System.out.println( "\n \n");
            //这里加一就是前面哪一位，其实就是把小的哪一位，挪到前面。
            array[preIndex+1]=current;

            printArray(array);
        }



    }


    /**
     * 希尔排序，插入排序的改进版。
     */
    private static  void shellSort(){
        int[] sourceArray = {1,5,7, 6,2,8,10,12,13,14,15,16,17,18,20,21,22,23,25,26,88};
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;

        System.out.println("------arr.length/3  ： "+arr.length+"   "+(arr.length/3));

        //arr.length/3大于1，才进行计算。  //动态定义间隔序列ki

        while (gap < arr.length/3) {
            gap = gap * 3 + 1;
            System.out.println("------希尔排序 gap ： "+gap);

        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        printArray(arr);

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
     * 运气好，一趟完成排序。后面只需要检查就好。
     * @param array
     */
    static void bubbleSort(int[] array){

        int temp;
        int size=array.length;
        //如果i从0起，下面j+1就越界了。
        for(int i=1;i<size;i++){
            System.out.println("\n");
            //每次都少循环 i 次,因为每次都把最大的移到后面。
            for(int j=0;j<size-i;j++){
                if(array[j]>array[j+1]){

                    //保存二个比较中，最大的数值
                    temp=array[j];
                    //往后挪(实是为了交互双方位置)
                    array[j]=array[j+1];
                    //往前挪
                    array[j+1]=temp;

                    printArray(array);
                    System.out.println("----------------------"+(size-i)+"\n");


                }



            }

        }

        //printArray(array);

    }



    private static void printArray(int[] sort){

        for (int aSort : sort) {
            System.out.print(aSort + " ,");
        }
        System.out.println( "");
    }
    public static void main(String[] args) {

        int[] sort = {6,5,4,3,2,1};
      //  int[] sort = {1,3,6,4};
       // int[] sort = {5,2};
       // int[] sort = {5,2,2};


/*        System.out.println("\n------冒泡排序-----");
        bubbleSort(sort);*/

  /*      System.out.println("\n-----希尔排序------");
        shellSort();
*/

/*        System.out.println("\n-----选择排序------");
        selectionSort(sort);*/

/*        System.out.println("\n-----插入排序------");
        insertSort();*/

    /*    int[] array = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
        binarySearch2(array,13);*/
      //  binarySearch2(array,1);


    }




}
