package com.z.algorithm;

/**
 * 字符串查找算法
 *author：zkb
 */
public class KmpTest {

    public static void main(String[] args) throws InterruptedException {

        String[] match={"a","b","c","d","e"};
       // getNext(match);
        kmpFind();
        //bfFind();

      //  char[] chars={1,2,1,2};
    //    GetNext(chars);
    }

    /**
     * 字符串暴力查找
     * 暴力匹配（朴素模式匹配BF）
     * @return
     */
    private static  int  bfFind(){
        //i
        String[] strings={"a","d","e","c","d","e","z","f"};
        //j
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
            //打印而已
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


    private static  void kmpFind() throws InterruptedException {
        //i
        String[] strings={"a","a","a","a","a","a","c","a","b","a","a","a","b","a"};
        //j
          String[] match={"a","a","a","b","a"};//j
        //String[] match={"a","b","b","c","c"}; //-1_0_0_0_0_0
        int i=0,j=0;
        int[] next = getNext(match);
        while(i<strings.length&&j<match.length){

            if(j!=-1){
                System.out.println("-----strings[i]:"+strings[i]);
                System.out.println("-----strings[j]:"+match[j]+"\n");
            }
            if(j==-1||strings[i].equals(match[j])){
                i++;
                j++;
            }else {
                //match 回到 j
                j=next[j];
                System.out.println("j:"+j);
            }
        }

        if(j==match.length){
            //打印而已
            int start=i-match.length;
            System.out.println("找到");

        }else {
            System.out.println("没找到");

        }


    }

    private static int[]  getNext(String[] strings){

        int[] next=new int[strings.length+1];

        int i=0,j=-1;
        next[0]=j;//-1
        // {"a","b","a","b","b"};
        //后挪一位，比较相同就加一。
        while (i<strings.length){
            if(j==-1||strings[i].equals(strings[j])){

                //j=-1,所以 下标1 一定是0,-1++=0;
                i++;
                j++;

                next[i]=j;

            }else {
                j=next[j];
            }

        }


        for (int k : next) {
            System.out.print("_" + k);
        }
        System.out.println("");
        
        return next;

    }


    static void GetNext(char T[])
    {
        int[] next=new int[T.length+1];
        int j=0,k=-1;
        next[j]=k;
        while(j<T.length)
        {
            if(k==-1||T[j]==T[k])
            {
                j++;
                k++;
                next[j]=k;
            }
            else k=next[k];
        }

        for (int s : next) {
            System.out.print(" " + s);
        }
    }

}
