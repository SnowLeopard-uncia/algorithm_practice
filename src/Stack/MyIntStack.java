package Stack;

import java.util.Stack;

public class MyIntStack {
    private int [] elements;
    private int size;
    //size是栈内元素个数
    private static final int DEAFULT_CAPASITY=20;

    //自带的stack类
    private Stack<Integer> stackData = new Stack<>();

    public MyIntStack() {
        this(DEAFULT_CAPASITY);
        //这个this是构造函数的意思？因为没有下面那个带参构造函数没法用这个this
    }


    public MyIntStack(int deafultCapasity) {
        elements = new int[deafultCapasity];
    }

    public void push(int value){
        if (size>=elements.length){
            int[]temp = new int[elements.length*2];
            System.arraycopy(elements,0,temp,0,elements.length);
            elements=temp;
        }
        elements[size++]=value;
    }

    public int pop(int value){
        return elements[--size];
    }



}
