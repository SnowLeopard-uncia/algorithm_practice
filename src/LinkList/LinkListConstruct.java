package LinkList;

public class LinkListConstruct<T> {
    //头节点
    private ListNode<T> first;
    //当前结点
    private ListNode<T> current;
    //链表长度
    private int size;

    public LinkListConstruct() {
        first=current=null;
        size=0;
    }

    /**
     * 添加结点
     */

    //链表头部添加结点
    public void addFirstNode(T data){
        //添加的内容封装成结点   好家伙一开始忘记赋值data了
        ListNode<T> node = new ListNode<T>(data);
        //新节点的指针指向原本第一个结点
        node.next=first;
        //新添加的结点为第一个
        first=node;
        size++;
    }

    //链表尾部添加结点
    public void addNode(T data){
        if (size==0){
            addFirstNode(data);
            return;
        }else {
            //定位到最后一个结点
            locateNode(size-1);
            ListNode<T> listNode = new ListNode<T>(data);
            current.next=listNode;
//            listNode  = current.next;  这样不对哦
            size++;

        }
    }


    //链表中间任意位置添加结点
    public T insertNode(int index,T data){
        if (size==0){
            addFirstNode(data);
            return null;
        }else {
            locateNode(index);
            //现在current是index位置的结点了
            ListNode<T> newNode = new ListNode<T>(data);
            //新结点的指针指向下一个结点
            newNode.next = current.next;
            //当前结点的指针指向新指针
            current.next=newNode;
            size++;
            return newNode.val;
        }
    }

    //

    /**
     * 获取指针位置
     */
    //将当前指针定位到所需结点位置
    public  void  locateNode(int index){
        //判断指针是否越界
        if (index<0 && index>size){
            throw new IndexOutOfBoundsException("数组越界");
        }

        int i = 0;
        //从第一个结点开始遍历到第index个结点
        for (current=first; current.next!=null && i<index;i++){
            current = current.next;
            //循环过后current就是index位置的结点
        }
    }

    //根据索引位置获取结点的数据
    public T getNodeData(int index){
        if (size==0){
            throw new IndexOutOfBoundsException("链表为空");
        }
        //当前指针定位到index的位置
        locateNode(index);
        return current.val;
    }


    //根据索引位置获取结点
    public ListNode getNode(int index){
        if (size==0){
            throw new IndexOutOfBoundsException("链表为空");
        }
        //当前指针定位到index的位置
        locateNode(index);
        return current;
    }
    /**
     * 删除结点
     */
    //删除第一个结点 返回数据
    public T removeFirstNode(){
        //检查当前链表第一个结点是否为空
        if (first == null){
            try {
                throw new Exception("链表为空");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        //获取被删除结点的数据
        T temp = first.val;
        //第二个结点设置为第一个
        first.next=first;
        size--;
        return temp;
    }


     // 删除中间位置结点
     public T removeNode(int index){
        if (size==0){
            try {
                throw new Exception("链表为空");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        //把当前指针current定位到 需删除结点（index）的前1个结点
        locateNode(index-1);
        //现在current.next是需要被删除的结点
         T temp = (T) current.next.val;
        //temp保存要删除结点的数据
         current.next=current.next.next;
        //指针 指向 被删结点的下一个结点
         size--;
         return temp;
     }


}
