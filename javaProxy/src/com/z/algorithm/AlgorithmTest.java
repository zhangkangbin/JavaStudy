package com.z.algorithm;

/**
 * User: zhangkb
 * Date: 2019/5/10 0010
 * Time: 上午 9:41
 *
 * @author zhangkb
 */
public class AlgorithmTest {


    public static void mp(int[] sort) {
        int temp;
        int length = sort.length;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                //
                if (sort[i] < sort[j]) {
                    temp = sort[i];
                    //交换双方位置
                    sort[i] = sort[j];
                    //交换双方位置

                    sort[j] = temp;
                }

            }

        }


    }

    public static void bubbleSort(int[] a) {
        int temp;
        int size = a.length;
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size - i; j++) {
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
                    for (int aSort : a) {
                        System.out.print(aSort + " ,");
                    }
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

    public static void main(String[] args) {

        int[] sort = {7, 6, 2, 1};

        bubbleSort(sort);


    }
}
