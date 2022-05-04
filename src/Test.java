import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//        list.add(3);
//        list.add(2);
//        list.add(1);
//        list.add(0);
//        while (list.size()!=0) {
//            list.remove(1);
//        }
        //remove(1)不报错是因为remove方法里用了arraycopy
        int[] a ={7,2,1,4};
//        findBiggest(a,3,2);

        /**
         * 像Java是没有指针的，同时也不对程序员暴露其元素的地址，寻址操作完全交给虚拟机。
         * [I@1b6d3586
         * [I@4554617c
         * [I@74a14482
         * 这里的数值也是16进制，这不是真正的地址，而是经过处理过后的数值了，我们也可以看出，二维数组的每一行头结点的地址是没有规则的，更谈不上连续。
         */
//        int[][] arr = {{1, 2, 3}, {3, 4, 5}, {6, 7, 8}, {9,9,9}};
//        System.out.println(arr[0]);
//        System.out.println(arr[1]);
//        System.out.println(arr[2]);

        System.out.println(removeElement(a,5));

    }

    /**
     * 数组任意一个数减去x，能进行k次，数组最大值尽可能小
     * 我的思路是每次都找最大值，减去x，最后找出最大值
     * @param a
     * @param x
     * @param k
     */
    public static void findBiggest(int[] a, int x, int k){
        int[] b=new int[a.length];
        for (int i = 0; i < k; i++) {
            b=findMax(a,x);
        }
        int max = Integer.MIN_VALUE;
        int temp =-1;
        for (int i = 0; i < b.length; i++) {
            if (b[i]>max){
                max=b[i];
                temp=i;
            }
        }
        System.out.println(b[temp]);

    }


    private static int[] findMax(int[] a, int x) {
        int max = Integer.MIN_VALUE;
        int temp =-1;
        for (int i = 0; i < a.length; i++) {
            if (a[i]>max){
                max=a[i];
                temp=i;
            }
        }
        int res = max-x;
        a[temp]=res;
        return a;
    }


    /**
     * 移除元素
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     *
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     *
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     *
     * 返回值是新数组的长度
     *
     * 思路：快慢双指针，快指针先走，遇到不相同的数字把慢指针拉上来同步，遇到要删除的数字，慢指针留在原地，快指针指到的数字赋值到慢指针
     */
    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        for(slow=0;fast< nums.length;fast++){
            //这个时候因为找到了，所以fast一直往前走，slow在原地接收填补
            if (nums[fast]!=val){
                //这个时候没有相等，所以是同步走，fast走一步，slow走一步，把fast的挪到slow
                nums[slow]=nums[fast];
                slow++;
            }
        }
        return slow; //这个slow是删除之后的了
    }


}
