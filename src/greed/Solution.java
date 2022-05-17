package greed;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] g ={10,9,8,7};
        int[] s = {5,6,7,8};
        System.out.println(findContentChildren(g,s));
    }
    /**
     * 455 分发饼干
     * 假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。
     * 对每个孩子 i，都有一个胃口值g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j]。
     * 如果 s[j]>= g[i]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足
     * 你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。
     * 链接：https://leetcode-cn.com/problems/assign-cookies
     */
    public static int findContentChildren(int[] g, int[] s) {
        int count=0;
        int index=0;
        Arrays.sort(s);
        Arrays.sort(g);
        for (int i = 0; i < s.length && index<g.length; i++) { //饼干的大小
           //孩子的胃口
                if (s[i]>=g[index]){
                    count++;
                    index++;
                }

        }
        return count;
    }
}
