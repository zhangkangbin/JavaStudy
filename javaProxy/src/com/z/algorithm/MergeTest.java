package com.z.algorithm;


public class MergeTest  extends BaseAlgorithm{

    /**
     *二路归并
     * @param arr
     * @param left
     * @param right
     */
    public static void merSort(int[] arr,int left,int right){

        if(left<right){

            //不断切一半。直到切不动,即left==right时候。
            int mid = (left+right)/2;
            System.out.printf("-----------------left:%s  mid:%s right:%s \n",left,mid,right);
            merSort(arr,left,mid);//左边归并排序，使得左子序列有序

          //  printArray(arr);
            merSort(arr,mid+1,right);//右边归并排序，使得右子序列有序
           // printArray(arr);
            merge(arr,left,mid,right);//合并两个子序列
        }/*else {
            System.out.printf("-----------------left:%s  right:%s \n",left,right);
        }*/
    }
    private static void merge(int[] arr, int left, int mid, int right) {

        System.out.printf("left:%s mid:%s right:%s \n",left,mid,right);
        System.out.printf("size:%s  \n",(right - left + 1));

        //ps：也可以从开始就申请一个与原数组大小相同的数组，因为重复new数组会频繁申请内存

        int[] temp = new int[right - left + 1];

        int i = left;
        int j = mid+1;
        int k = 0;

        while(i<=mid&&j<=right){

            if (arr[i] < arr[j]) {
                //原封不动填进去，i++,指向左边数组下一位。
                temp[k++] = arr[i++];
            } else {
                //把小的填在前面，右边j++,即右边数组下一个，继续对比下一个;
                temp[k++] = arr[j++];
            }
        }
        //将左边剩余元素填充进temp中。（优势在这里，如果右边组比对完毕，剩下的直接填进去就好。）
        while(i<=mid){
            temp[k++] = arr[i++];
        }

        /*
         * 将右序列剩余元素填充进temp中（优势在这里，如果左边边组比对完毕，剩下的直接填进去就好。）
         * 比如 0,1,2 和 5,7,9所以这时候， 5,7,9 。直接填在右边就好。
         */

        while(j<=right){
            temp[k++] = arr[j++];
        }


        /**
         * 将temp中的元素全部拷贝到原数组中,其实就是把排好序的元素，负责到数组中。
         * 比如 9,2,0,4,3,7,6,5,8,1
         * 对比 是 9 ,2, 排序后是 2 ，9
         * 复制到数组中是，注意前面的 2 ，9。
         * 2,9,0,4,3,7,6,5,8,1
         */
        for (int k2 = 0; k2 < temp.length; k2++) {
            arr[k2 + left] = temp[k2];
        }

        //调试功能：只是为了打印数组。
        printArray(temp);
    }
    public static void main(String args[]){
        int[] test = {9,2,0,4,3,7,6,5,8,1};
        merSort(test,0,test.length-1);
        printArray(test);
    }

}
