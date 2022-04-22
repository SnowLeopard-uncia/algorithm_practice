package StringProblem;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
//        System.out.println(isTwoPower(8));
        System.out.println(deleteString("3331"));
    }

    //待改进
    public static int deleteString(String s){
        //返回值为最少删除的个数
        return s.length()-dp(s);
    }
    public static int dp(String s){
        if (s.length()==0){
            return 0;
        }
        String subString="";
        int res = Integer.MAX_VALUE; //找最小设最大值
        for (int i = 0; i < s.length(); i++) {
             subString = deleteAtString(s,i);
            int n=Integer.parseInt(subString);
            if (isTwoPower(n)){
                return subString.length();
            }
        }
     return dp(subString);
    }

    /**
     * 删除啊字符串中指定位置的字符
     */
    public static String deleteAtString(String sourceString, int index){
        StringBuffer stringBuffer = new StringBuffer(sourceString);
        stringBuffer.deleteCharAt(index);
        return stringBuffer.toString();
    }

    /**
     * 删除字符串中指定字符
     * @param sourceString
     * @param chElemData
     * @return
     */
    public static String deleteCharString(String sourceString, char chElemData) {
        String tmpString = "";
        tmpString += chElemData;
        StringBuffer stringBuffer = new StringBuffer(sourceString);
        int iFlag = -1;
        do {
            iFlag = stringBuffer.indexOf(tmpString);
            if (iFlag != -1) {
                stringBuffer.deleteCharAt(iFlag);
            }
        } while (iFlag != -1);
        return stringBuffer.toString();
    }

    /**
     * 空字符表示数据为空； 空格字符表示数据不为空，为一个空格字符。
     * Java和C++中使用'\0'表示空字符，Python使用''表示空字符。
     * char replace=''; Java中这么写会报错
     */

    /**
     * Java删除字符串中的指定字符
     * 1. 替换函数，替换成空白
     * String test  = ("helloworld");
     * test = test.replace("hello","");
     * 2.截取函数，删除字符
     * String test = ("helloworld");
     * test = test.substring(5); //输出world
     *
     * char newStr='\0';
     * char oldStr = s.charAt(i);
     * subString = s.replace(oldStr,newStr);
     * replace 会把所有符合的都换掉
     */

    /**
     * 判断某个数是不是2的幂次方
     * @param n
     * @return
     */
    //2的幂次方都满足一个特点：n&(n-1)等于0。
    // 2的0次幂是1，对应二进制：0000 0000 0000 0000 0000 0000 0000 0001
    //2的1次幂是2，对应二进制：0000 0000 0000 0000 0000 0000 0000 0010
    //2的2次幂是4，对应二进制：0000 0000 0000 0000 0000 0000 0000 0100
    //2的3次幂是8，对应二进制：0000 0000 0000 0000 0000 0000 0000 1000
    public static boolean isTwoPower(int n){
        return n>0 && (n&(n-1))==0;
    }
}
