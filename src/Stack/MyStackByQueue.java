package Stack;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 225. 用队列实现栈
 * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
 * 实现 MyStack 类：
 * void push(int x) 将元素 x 压入栈顶。
 * int pop() 移除并返回栈顶元素。
 * int top() 返回栈顶元素。
 * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
 * https://leetcode.cn/problems/implement-stack-using-queues/submissions/
 */
public class MyStackByQueue {
    /**
     一个队列实现
     https://programmercarl.com/0225.%E7%94%A8%E9%98%9F%E5%88%97%E5%AE%9E%E7%8E%B0%E6%A0%88.html
     两个Queue，两个Deque，一个Deque的方法
     */
    Queue<Integer> queue = new LinkedList<>();
//    Deque（是个接口） 这个东西很神奇啊有Queue的方法也有Stack的方法，还有自己独有的方法，
//    就是可以addFitst，addLast，震惊到我

    public MyStackByQueue() {

    }
    public void push(int x) {
        queue.offer(x);
    }
//或者top是不需要改变顺序的，pop的时候才需要改变顺序？不然top改了一遍之后，pop那边又复原了。
    public int pop() {
        int size = queue.size();
        for (int i =0;i<size-1;i++){
            int j  = queue.remove();
            queue.add(j);
        }
        return queue.remove();
    }
//决定top看完最后那个元素之后立刻复原，也就是也调到后面去,虽然很蠢，但是过了耶( •̀ ω •́ )y
    public int top() {
        int size = queue.size();
        for (int i =0;i<size-1;i++){
           int j  = queue.remove();
           queue.add(j);
        }
        int result = queue.remove();
        queue.add(result);

        return result;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
class Test{

    public static void main(String[] args) {
        MyStackByQueue myStack = new MyStackByQueue();
        myStack.push(1);
        myStack.push(2);
        System.out.println(myStack.top()); // 返回 2
        System.out.println(myStack.pop()); // 返回 2
        System.out.println(myStack.empty());  // 返回 False

    }
}