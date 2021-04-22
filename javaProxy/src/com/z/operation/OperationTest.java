package com.z.operation;

/**
 * 运算符计算
 * ~ & ^ |
 * int 为32位
 */
public class OperationTest {

    public static void main(String[] args) {

        System.out.println(0b11111111111111111111111111111110 |0b10000001);
        System.out.println(129 |-2);
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
        int b=127;//1111111 ,正数前面0为补位。
        int c=-2; //-2为，01，因为是负数前面不是补0，是补1，补够32位。（前面说了int 为32位。）11111111111111111111111111111110 ,

        System.out.printf("二进制 %s : %s%n",a,Integer.toBinaryString(a));
        System.out.printf("二进制 %s : %s%n",b,Integer.toBinaryString(b));
        System.out.printf("二进制 %s : %s%n",c,Integer.toBinaryString(c));
        System.out.println("&与运算:"+(a&b));
        System.out.println("&与运算:"+(a&c));
        System.out.println("&与运算:"+(b&c));

        System.out.println("--------------------------------------\n");
    }
    private static  void test1(){

        //或运算符用符号“|”
        //两个位只要有一个为1，那么结果就是1，否则就为0
        int a=129;//00000000000000000000000010000001

        int b=128;//00000000000000000000000010000000
        int c=-2; //11111111111111111111111111111110

        System.out.println("|或运算:"+(a|b));
        System.out.println("|或运算:"+(a|c));
        System.out.println("|或运算:"+(b|c));


        //得到的结果，保留高位，其他取反，加一。得到结果。
        System.out.println("--------------------------------------\n");
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

        System.out.println("~非运算:"+~a);
        System.out.println("~非运算:"+(~b));
        System.out.println("~非运算:"+(~c));
        System.out.println("~非运算:"+(~d));
        System.out.println("~非运算e:"+(~e));

        System.out.println("~非运算de:"+0b11111111111111111111111101111110);


        System.out.println("--------------------------------------\n");
    }

    private static  void test3(){

        //异或运算符是用符号“^”表示的，其运算规律是：

        //两个操作数的位中，相同则结果为0，不同则结果为1
        int a=129;//10000001
        int b=2;// 00000000000000000000000000000010
        int c=-3;//11111111111111111111111111111101 //补码

       // System.out.printf(Integer.toBinaryString(c));
        System.out.printf("^异或运算 %s ^ %s : %s %n",a,b,a^b);
        System.out.printf("^异或运算 %s ^ %s : %s %n",b,c,b^c);
        System.out.printf("^异或运算 %s ^ %s : %s %n",a,c,a^c);


        //00000110
       // System.out.println("^异或运算:"+(~d));

        System.out.println("--------------------------------------\n");
    }

    private static  void test4(){

        /**
         * <<	左移运算符，将运算符左边的对象向左移动运算符右边指定的位数（在低位补0）	x<<3
         * >>	"有符号"右移运算 符，将运算符左边的对象向右移动运算符右边指定的位数。使用符号扩展机制，也就是说，如果值为正，则在高位补0，如果值为负，则在高位补1.x>>3
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

        System.out.println("--------------------------------------\n");
    }


}
