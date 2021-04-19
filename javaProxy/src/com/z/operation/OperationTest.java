package com.z.operation;

/**
 * 运算符计算
 * ~ & ^ |
 * int 为32位
 */
public class OperationTest {

    public static void main(String[] args) {



        System.out.println("|或运算:"+(3<<3));
        System.out.println("|或运算:"+(-1<<29));
        System.out.println("|或运算:"+(0<<29));
        System.out.println("|或运算:"+(1<<29));
        System.out.println("|或运算:"+(2<<29));

        test0();
        test1();
        test2();
        test3();
        test4();

    }

    private static  void test0(){

        //&与运算
        //两个操作数中位都为1，结果才为1，否则结果为0，
        int a=129;//10000001
        int b=128;//10000000
        int c=127;//01111111 ,前面0为补位。

        System.out.println("&与运算:"+(a&b));
        System.out.println("&与运算:"+(a&c));
        System.out.println("&与运算:"+(b&c));
    }
    private static  void test1(){

        //或运算符用符号“|”
        //两个位只要有一个为1，那么结果就是1，否则就为0
        int a=129;//10000001
        int b=128;//10000000
        int c=127;//01111111 ,前面0为补位。

        System.out.println("|或运算:"+(a|b));
        System.out.println("|或运算:"+(a|c));
        System.out.println("|或运算:"+(b|c));
        System.out.println("--|或运算:"+(128|0));
    }
    private static  void test2(){

        // 非运算符
        // 非运算符用符号“~”表示，其运算规律如下：
        // 如果位为0，结果是1，如果位为1，结果是0
        int a=129;//10000001
        int b=128;//10000000
        int c=127;//01111111 ,前面0为补位。
        int d=2;//10
        int e=-3;//11

        //这个有点奇怪，网上的教程就是千篇一律的。害人呀，找不到计算的方法。
        //就是先取反,即0变成1，1变成0，然后加1，然后再取反。


        System.out.println("~非运算:"+~a);
        System.out.println("~非运算:"+(~b));
        System.out.println("~非运算:"+(~c));
        System.out.println("~非运算:"+(~d));
        System.out.println("~非运算e:"+(~e));
        System.out.println("~非运算5:"+~5);
        System.out.println("~非运算-65:"+~-65);
        System.out.println("~非运算-4:"+~-4);

        System.out.println("& ~非运算:"+(a & ~d));



        //2 ,0b代表二进制，int 是三十二位，补0
        System.out.println(0b00000000000000000000000000000010);
        //-3 0b代表二进制，int 是三十二位，补0
        System.out.println(0b11111111111111111111111111111101);
    }

    private static  void test3(){

        //异或运算符是用符号“^”表示的，其运算规律是：

        //两个操作数的位中，相同则结果为0，不同则结果为1
        int a=129;//10000001
        int b=128;//10000000
        int c=127;//01111111 ,前面0为补位。
        int d=2;//10,00000010,前面0为补位。
        int e=4;//100,00000100,前面0为补位。

        System.out.println("^异或运算:"+(a^b));
        System.out.println("^异或运算:"+(b^c));
        System.out.println("^异或运算:"+(a^c));

        //00000110
        System.out.println("^异或运算:"+(d^e));
       // System.out.println("^异或运算:"+(~d));
    }

    private static  void test4(){

        /**
         * <<	左移运算符，将运算符左边的对象向左移动运算符右边指定的位数（在低位补0）	x<<3
         * >>	"有符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。使用符号扩展机制，也就是说，如果值为正，则在高位补0，如果值为负，则在高位补1.	x>>3
         * >>>	"无符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。采用0扩展机制，也就是说，无论值的正负，都在高位补0.
         */
        /**
         * 2进制为00000010，后移3为了00010000 ，等于 16
         */
        System.out.println("<<:"+(2<<3));
        /**
         * 16进制为00010000，前移2为了00000100 等于4
         */
        System.out.println(">>:"+(16>>2));
        System.out.println(">>:"+(-16>>2));
        System.out.println(">>>:"+(-8>>>1));
        System.out.println(">>>:"+(-0b00001000));
        System.out.println(">>>:"+(-0b00000100));
    }


}
