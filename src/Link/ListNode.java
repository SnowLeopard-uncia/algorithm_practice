package Link;

public class ListNode<T> {
    /**
     * 设置结点结构
     */
    T val;
      ListNode next;
      ListNode() {}
      ListNode(T val) { this.val = val; }
      ListNode(T val, ListNode next) { this.val = val; this.next = next; }
}
