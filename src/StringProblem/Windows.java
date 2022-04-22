package StringProblem;

import java.util.HashMap;
import java.util.Map;

public class Windows {
    public static void main(String[] args) {

    }
/**
 * unordered_map 就是哈希表（字典），相当于 Java 的 HashMap，
 * 它的一个方法 count(key) 相当于 Java 的 containsKey(key) 可以判断键 key 是否存在。
 * 可以使用方括号访问键对应的值 map[key]。需要注意的是，如果该 key 不存在，C++ 会自动创建这个 key，
 * 并把 map[key] 赋值为 0。所以代码中多次出现的 map[key]++ 相当于
 * Java 的 map.put(key, map.getOrDefault(key, 0) + 1)。
 *
 * 另外，Java 中的 Integer 和 String 这种包装类不能直接用 == 进行相等判断，
 * 而应该使用类的 equals 方法，这个语言特性坑了不少读者，在代码部分我会给出具体提示。
 */
    /**
     * 算法框架
     */
    /*
    public void slide(){
        int left=0;
        int right=0;
        int[] window = new int[10];
        String a="hello world";
        while(right< a.length()){
            window.add(s[right]);
            right++;
        }
        while(windows need shrink){
                windows.remove([left]);
                left--;
        }
    }

     */

    //力扣567 滑动窗口法
    //给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
    //
    //换句话说，s1 的排列之一是 s2 的 子串 。
    //链接：https://leetcode-cn.com/problems/permutation-in-string
//    public boolean checkInclusion(String s1, String s2) {
//        int left = 0;
//        int right =0 ;
//        Map<Character,Integer> windows,need = new HashMap<Character,Integer>();
//        for (char c: s1.toCharArray()) {
//            //需要的字符串加进
//            need.put(c, need.getOrDefault(c,0)+1);
//        }
//        for (int i = 0; i < s1.length(); i++) {
//            char c = s1.charAt(i);
//
//        }
//        while (right<s2.length()){
//
//            windows[s2[right]]++;
//        }
//
//    }

}
