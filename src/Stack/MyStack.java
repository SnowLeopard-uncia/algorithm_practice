package Stack;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Stack;

/**
 * 使用Array List实现栈
 */
public class MyStack{
    private ArrayList<Object> list = new ArrayList<>();

    //若栈空返回true
    public boolean isEmpty(){
        return list.isEmpty();
    }

    //返回栈的元素个数
    public int getSize(){
        return list.size();
    }

    //返回栈顶整数而不从栈中删除
    public Object peek(){
        return list.get(getSize()-1);
    }

    //删除栈顶整数并返回
    public Object pop(){
        Object o = list.get(getSize()-1);
        list.remove(getSize()-1);
        return o;
    }

    //将整数存到栈顶
    public void push(Object o){
        list.add(o);
    }

    @Override
    public String toString() {
        return "MyStack{" +
                "list=" + list.toString() +
                '}';
    }
}
