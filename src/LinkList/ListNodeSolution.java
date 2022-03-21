package LinkList;

public class ListNodeSolution<T> {

    public static void main(String[] args) {
        //创建链表
        LinkListConstruct<Integer> linkList1 = new LinkListConstruct<Integer>();
        linkList1.addNode(1);
        linkList1.addNode(2);
        linkList1.addNode(4);

        LinkListConstruct<Integer> linkList2 = new LinkListConstruct<Integer>();
        linkList2.addNode(1);
        linkList2.addNode(3);
        linkList2.addNode(4);

//        printLinkList(linkList1.getNode(0));

//        mergeTwoLists(linkList1.getNode(0),linkList2.getNode(0));
        printLinkList(mergeTwoLists(linkList1.getNode(0),linkList2.getNode(0)));

    }

    //打印链表
    public static void printLinkList(ListNode linkList){
        while (linkList.next!=null){
            System.out.println(linkList.val);
            linkList=linkList.next;
        }

    }


    //21.将两个升序链表合并为一个新的 升序 链表并返回
    public static ListNode<Integer> mergeTwoLists(ListNode<Integer> list1, ListNode<Integer> list2) {
        ListNode<Integer> dummy = new ListNode<Integer>();
        ListNode<Integer> p = dummy;
        ListNode<Integer> p1=list1;
        ListNode<Integer> p2=list2;
        //任意一个为空都不能进行下去
        while (p1 !=null && p2 !=null){
            //比较p1和p2的大小，把小的链接到p
            if (p1.val > p2.val){
                p.next=p2;
                p2=p2.next;
            }else {
                p.next=p1;
                p1=p1.next;
            }
        // p 指针不断前进，别忘记这个！不然就会被覆盖了
            p = p.next;
        }
        if (p1!=null){
            p.next=p1;
        }
        if (p2!=null){
            p.next=p2;
        }
        //通过debug模式可以看出来dummy和p都是指向一个对象 ListNode@489
        //发现dummy的next里面的变量是随着p变化的,就是dummy的next和p指向的同一个区域的变量，所以p改变的时候其实dummy在不断增长
        return dummy.next;
    }
}
