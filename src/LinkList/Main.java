package LinkList;

// Created on 纵纹腹小鸮的iPad.

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
         printLinkList(mergeKLists(lists));
        // System.out.println(findFromEnd(list1,2)+"");
//    System.out.println(removeNthFromEnd(list1,2).val);
//printLinkList(removeNthFromEnd(list1,3));
//        System.out.println(middleNode(list1));
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


    //单链表倒数第K个结点
//我一开始想到的是先遍历一遍把一条链拉出来，再看倒数第K个是什么
//此处是只遍历一遍的做法 双指针法，主要想法是第一次遍历的时候就可以走过那个倒数第k个结点，所以可以找个标记
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



}

