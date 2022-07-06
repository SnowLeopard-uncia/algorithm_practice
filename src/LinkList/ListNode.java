package LinkList;

public class ListNode<T> {
    /**
     * 设置结点结构
     */
     public T val;
     public ListNode<T> next;

    public T getVal() {
        return val;
    }

    public void setVal(T val) {
        this.val = val;
    }

    public ListNode<T> getNext() {
        return next;
    }

    public void setNext(ListNode<T> next) {
        this.next = next;
    }

   public ListNode() {}
   public ListNode(T val) { this.val = val; }
   public ListNode(T val, ListNode<T> next) { this.val = val; this.next = next; }
}
