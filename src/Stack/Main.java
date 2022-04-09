package Stack;

public class Main {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(3);
        stack.push(5);
        stack.push(7);
        System.out.println(stack.toString());
        System.out.println(stack.peek());

        while (!stack.isEmpty()){
            stack.pop();
        }
        System.out.println(stack.toString());
    }
}
