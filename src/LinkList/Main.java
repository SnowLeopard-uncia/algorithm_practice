package LinkList;

// Created on 纵纹腹小鸮的iPad.

import java.util.List;
import java.util.PriorityQueue;

/**
 * 就是在iPad写的链表练习
 */


public  class Main {
    public static void main(String[] args) {
        ListNode list4 = new ListNode(4,null);
        ListNode list3 = new ListNode(3,list4);
        ListNode list2 = new ListNode(2,list3);
        ListNode list1 = new ListNode(1,list2);
        // printLinkList(list1);

        ListNode[] lists = new ListNode[]{list1,list2,list3};
       //  printLinkList(mergeKLists(lists));
        // System.out.println(findFromEnd(list1,2)+"");
//    System.out.println(removeNthFromEnd(list1,2).val);
//printLinkList(removeNthFromEnd(list1,3));
//        System.out.println(middleNode(list1));
//        System.out.println(fib(4));
//        printNode(reverseList(list1));
    }

    /**
     * 打印链表
     * @param linkNode
     */
    public static void printLinkList(ListNode linkNode){
        while(linkNode != null){
            System.out.println(linkNode.val);
            linkNode=linkNode.next;
        }
    }

// public void initListNode(){

//     ListNode list3 = new ListNode(3,null);
//      ListNode list2 = new ListNode(2,list3);
//          ListNode list1 = new ListNode(1,list2);
// }


//合并K个结点
 public static ListNode mergeKLists(ListNode[] lists){
     if(lists.length == 0){
         return null;
     }

     //虚拟头节点
     ListNode dummmy = new ListNode();
     ListNode p = dummmy;
     //优先级队列，最小堆
     PriorityQueue<ListNode> pq = new PriorityQueue<>(
         lists.length,(a,b) -> ((int) a.val - (int) b.val)
     );

     //说找不到这个优先队列的类

     //把lists里面的结点加进去优先级队列，形成一个堆
     for(ListNode head: lists){
         if(head != null){
             pq.add(head);
         }
     }

     while(!pq.isEmpty()){
         //获取最小节点到结果链表中
         ListNode linkNode = pq.poll();
         p.next = linkNode;
         if(linkNode.next != null){
             pq.add(linkNode.next);
         }
         //P指针前进
         p=p.next;
     }
     return dummmy.next;

 }


    /**
     *     单链表倒数第K个结点
     * 我一开始想到的是先遍历一遍把一条链拉出来，再看倒数第K个是什么
     * 此处是只遍历一遍的做法 双指针法，主要想法是第一次遍历的时候就可以走过那个倒数第k个结点，所以可以找个标记
     * @param head
     * @param k
     * @return
     */

    public static ListNode findFromEnd(ListNode head, int k){
        ListNode p1 = head;

        //p1先走k步
        for(int i = 0;i<k ;i++){
            p1=p1.next;
        }
        //p2从头开始
        ListNode p2 = head;
        while(p1!=null){
            p2 = p2.next;
            p1 = p1.next;
        }
        //当1 走到底，2就走到了倒数第k个
        return p2;

    }

    public static ListNode removeNthFromEnd(ListNode head, int n){
        //如果只有n个，要删除n个的话，就是要删除头节点，头节点就不用单独领出来讨论
        //虚拟头结点
        ListNode dummmy = new ListNode();
        dummmy.next = head;
        //删除倒数第n个，要找倒数第n+1个结点
        ListNode x = findFromEnd(dummmy,n+1);
        //删掉倒数第n个结点
        x.next = x.next.next;
        return dummmy.next;

    }


    public static ListNode middleNode(ListNode head){
        //快慢指针，慢指针一步x，快指针两步2x，当快指针走到最后 2x=n,所以n/2 = x,此时的慢指针为x
        //初始为首元结点，注意
        //int temp=0;
        ListNode slow = head;
        ListNode fast = head;
        // 快指针走到末尾时停止
        while(fast != null && fast.next !=null){
            // temp++;
            // System.out.println(slow.val);
            // System.out.println(temp);

            slow = slow.next;
            fast = fast.next.next;
            //  System.out.println(slow.val);
        }
        // 慢指针指向中点
        return slow;
    }

    //判断链表是否有环 用了快慢指针，快指针一次走两部，慢指针一次走一步，如果相同说明有环
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if (slow == fast){
                return true;
            }
        }  return false;
    }

    /**
     * 求链表的环的入口
     *     快慢指针，两指针必在环中相遇，假设已知慢指针走的步数是k，快指针走的是2k
     *     未知：假设链表头指针距离环入口的结点距离为a（要求的），两指针相遇的地方距离环入口距离为m
     *     k = a+m  2k = a+m+nc (c为圈的长度，n为转的次数),快指针在遇到慢指针前一直在转圈
     *     所以k=nc
     *     因为走到环入口所需要的步数为y= a+nc (从头节点走到环入口，或者在环内转圈到环的入口)
     *     因为k=nc，所以慢指针只要再走a就到环入口了
     *     让快指针从头结点开始，和慢指针相同的速度走a步，只要它们相遇就可以求出a是多少了
     * @param head
     * @return
     */


    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow){
                break;
            }
        }
//漏了这种情况，fast 遇到空指针说明没有环
        if (fast== null || fast.next == null){
            return null;
        }

        fast = head;
        while (fast!=slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;


    }

    //斐波那切数列，递归法
    public static int fib(int n){
        if (n==0 ) return 0;
        else if (n==1 ) return 1;
        else return fib(n-1)+fib(n-2);

    }

    /**
     * 反转链表 迭代法
     */
    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur!=null){  //cur不为空！
            ListNode next = cur.next; //先存着next，不然就丢了，作为下一次循环的主角
            cur.next=pre; //把next指向前一个
            pre = cur;  // 把pre指向现在的结点
            cur = next;  //把cur指向下一个结点
        }
        return pre;
    }

    public static void printNode(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }


}

