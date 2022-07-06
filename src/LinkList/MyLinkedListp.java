package LinkList;

class MyLinkedListp {

    public static void main(String[] args) {
        MyLinkedListp linkedList = new MyLinkedListp();
        linkedList.addAtHead(1);
        linkedList.addAtTail(3);
        linkedList.addAtIndex(1,2);   //链表变为1-> 2-> 3
        linkedList.get(1);            //返回2
        linkedList.deleteAtIndex(1);  //现在链表是1-> 3
        linkedList.get(1);            //返回3
    }

    //虚拟头结点
    MyLinkedListNode dummy;
    int size;

    public MyLinkedListp() {
//初始化虚拟头结点
        dummy = new MyLinkedListNode();
        size=0;
    }

    public int get(int index) {
        if(index < 0 || index>=size){ //index不能等于size！！！！！！
            return -1;
        }else{
            MyLinkedListNode cur = dummy;
            int n=0;
            while(cur!=null && cur.next!=null && n<index){
                cur = cur.next;
                n++;
            }
            return cur.next.val;  //这里返回的是cur.next，因为cur跑完上面的while之后返回的是index之前的，只有next才是index的
        }
    }

    public void addAtHead(int val) {
        MyLinkedListNode node = new MyLinkedListNode(val);
        node.next = dummy.next;
//        dummy.next = node.next;  笑死，什么循环赋值垃圾代码
        dummy.next = node;
        size++;
    }

    public void addAtTail(int val) {
        int n=0;
        MyLinkedListNode cur = dummy;
        while(cur.next!=null && n<size){
            cur= cur.next;
            n++;
        }
        MyLinkedListNode node = new MyLinkedListNode(val);
        cur.next = node;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(index >=0 && index <= size){ ////添加是可以等于size的,也可以等于0！
            int n=0;
            MyLinkedListNode cur = dummy;
            while(cur!=null && n<index){
                cur=cur.next;
                n++;
            }
            MyLinkedListNode node = new MyLinkedListNode(val);
            node.next=cur.next;
            cur.next=node;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if(index >=0 && index < size){ //删除是可以等于0的，就是不能大于或等于size
            int n=0;
            MyLinkedListNode cur = dummy;
            while(cur!=null && n<index){
                cur=cur.next;
                n++;
            }
            cur.next=cur.next.next;
            size--;
        }
    }

}
/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

class MyLinkedListNode{

    MyLinkedListNode next;
    int val;

    public MyLinkedListNode(){

    }
    public MyLinkedListNode(int val){
        this.val = val;
    }
}
