package base;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 此类用于基础练习
 */
public class Base {

    public static void main(String[] args) {
        practiceMap();
    }
    /**
     * HashMap的使用
     */
    public static void practiceMap(){
        //HashMap
        Map<Character,Integer> map = new HashMap<>();
        //Key和Value
        //使用put方法
        map.put('A',1);
        map.put('B',2);
        map.put('C',3);
        //  for 循环中使用 entries 实现 Map 的遍历 entrySet里有key和value，keySet和valueSet里只有key和value单独的集合
        for (Map.Entry<Character,Integer> entry:map.entrySet()){
            char a = entry.getKey();
            int b = entry.getValue();
            System.out.println(a+" "+b);
        }

        // 使用 for-each 循环遍历 key 或者 values，一般适用于只需要 Map 中的 key 或者 value 时使用。性能上比 entrySet 较好
        for (char key :
             map.keySet()) {
            System.out.println(key);
        }

        for (int value:
             map.values()) {
            System.out.println(value);
        }

        //使用迭代器（Iterator）遍历 我当时只记得这个
        //一种用于访问集合的方法，可用于迭代 ArrayList 和 HashSet 等集合迭代器 it 的两个基本操作是 next 、hasNext 和 remove。
        //
        //调用 it.next() 会返回迭代器的下一个元素，并且更新迭代器的状态。
        //
        //调用 it.hasNext() 用于检测集合中是否还有元素。
        //
        //调用 it.remove() 将迭代器返回的元素删除。
        Iterator<Map.Entry<Character,Integer>> entryIterator= map.entrySet().iterator();
        while (entryIterator.hasNext()){
            Map.Entry<Character,Integer> entry =entryIterator.next();
            char key = entry.getKey();
            int value = entry.getValue();
            if (value==2){
                entryIterator.remove(); //真的删掉惹
            }
            System.out.println("key"+key+" "+"value"+value);
        }

        //IDE 推荐：就是第一种，感觉确实比较简洁
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
           // map.remove('A'); //加了这个会有这个报错！ConcurrentModificationException 分析代码：这个一个在使用Iterator迭代器遍历时，同时用使用remove()方法进行了删除的操作
            System.out.println("key" + key + " " + "value" + value);
        } //API文档上也有说的!   在迭代时只可以用迭代器进行删除!

        //4. 通过键找值遍历，这种方式的效率比较低，因为本身从键取值是耗时的操作。
        for(char key : map.keySet()){
            int value = map.get(key);
            System.out.println(key+":"+value);
        }
//        System.arraycopy();
//        Object c;
//        c.equals();

    }


}
