package com.z.algorithm;

/**
 * 字符串查找算法
 *author：zkb
 */
public class KmpTest {

    public static void main(String[] args) {


        bfFind();
    }

    /**
     * 字符串暴力查找
     * 暴力匹配（朴素模式匹配BF）
     * @return
     */
    private static  int  bfFind(){
        String[] strings={"a","b","c","d","e","z","f"};
        String[] match={"d","e","z"};

        int i=0;
        int j=0;
        while(i<strings.length&&j<match.length){
            System.out.println("----"+strings[i]);
            if(strings[i].equals(match[j])){
                //如果找到匹配的下一位继续
                i++;
                j++;
            }else {
                i=i-j+1;
                //匹配的字符串match回到0
                j=0;
            }

        }

        if(j==match.length){
            int start=i-match.length;
            System.out.println("找到");
            for(int stringIndex=start;stringIndex<match.length+start;stringIndex++){
                System.out.print(strings[stringIndex]);
            }
            return i-match.length;
        }else {
            System.out.println("没找到");
            return 0;
        }

    }
}
