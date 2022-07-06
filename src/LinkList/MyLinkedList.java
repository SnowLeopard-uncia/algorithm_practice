package LinkList;

/**
 * 707
 * 设计链表的实现。您可以选择使用单链表或双链表。单链表中的节点应该具有两个属性：val和next。val是当前节点的值，next是指向下一个节点的指针/引用。如果要使用双向链表，则还需要一个属性prev以指示链表中的上一个节点。假设链表中的所有节点都是 0-index 的。
 *
 * 在链表类中实现这些功能：
 *
 * get(index)：获取链表中第index个节点的值。如果索引无效，则返回-1。
 * addAtHead(val)：在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
 * addAtTail(val)：将值为val 的节点追加到链表的最后一个元素。
 * addAtIndex(index,val)：在链表中的index个节点之前添加值为val 的节点。如index等于链表的长度，则该节点将附加到链表的末尾。如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
 * deleteAtIndex(index)：如果索引index 有效，则删除链表中的第index 个节点。
 * 链接：https://leetcode-cn.com/problems/design-linked-list
 */
public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.printLinkList();   //为什么加上这句就报空指针异常？？？明明只是打印？
        // 哦我知道了，因为打印那里，我没有用temp的结点，就直接用了head，所以打印完相当于把head给改变了，执行完打印方法后head就变成最后一个
        //所以这时候要用临时的结点，避免改变head
        System.out.println(linkedList.get(1));
                    //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3

        System.out.println(linkedList.get(1));
        //返回3
        linkedList.printLinkList();
    }
    //设置虚拟头结点 ， 不然就要分开头结点和其他结点
    MyListNode head;
    //存储链表元素个数
    int size;

    public MyLinkedList() {
        //初始化链表
        size=0;
        head = new MyListNode(0);
    }

    /**
     * 获取链表中第index个节点的值。如果索引无效，则返回-1。
     * @param index
     * @return
     */
    public int get(int index) {
        if (index<0 ||index >=size){ //等于size，跟数组一样，因为从0开始，所以最后一个是size-1;
            return -1;
        }
        MyListNode cur = head;
        //因为包含了一个虚拟头结点，所以查找到第index+1个 为什么说包含了呢，因为前面的构造函数的head，
        // 那个是虚拟的，不然的话构造函数应该写head = null，这样就没有虚拟头结点
        for (int i =0;i<=index;i++){
            cur = cur.next;
        }
        return cur.val;
    }

    void printLinkList(){
        MyListNode myListNode = head;
        while (myListNode.next!=null){
            System.out.println(myListNode.next.val);
            myListNode = myListNode.next;
        }

    }

    /**
     * 在链表的第一个元素之前添加一个值为val的节点。插入后，新节点将成为链表的第一个节点。
     * @param val
     */
    public void addAtHead(int val) {
        MyListNode listNode = new MyListNode(val);
        listNode.next = head.next;
        head.next=listNode;
        size++;//这记得！

    }

    public void addAtTail(int val) {
//        addAtIndex(size,val);
        MyListNode listNode = new MyListNode(val);
        MyListNode cur = head;
        for (int i = 0; i < size; i++) {
            cur = cur.next;
        }
        cur.next=listNode;
        size++;

    }

    /**
     * 在链表中的index个节点之前添加值为val 的节点。如index等于链表的长度，则该节点将附加到链表的末尾。
     * 如果 index 大于链表长度，则不会插入节点。如果index小于0，则在头部插入节点。
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index>size){  //为什么这里index可以等于size呢，因为添加是无中生有，添加到size就相当于在最后添加
            return;
        }
        if (index <0){
            index =0;
        }
        size++; //记得这个！！！！！
        //找到要插入结点的前驱
        MyListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        MyListNode add = new MyListNode(val);
        add.next=pre.next;
        pre.next=add;

    }

    /**
     * 如果索引index 有效，则删除链表中的第index 个节点。
     * @param index
     */
    public void deleteAtIndex(int index) {
        if (index<0 || index>=size){  //哇注意这里，我居然漏了个等号，为什么呢？因为这样就数组越界了呀
            return;
        }
        MyListNode cur = head;
        for (int i = 0; i <index;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;

        size--; //这个要记得
    }
}
class MyListNode{
    int val;
    MyListNode next;

    public MyListNode(int val) {
        this.val = val;
    }

    public MyListNode() {
    }
}
