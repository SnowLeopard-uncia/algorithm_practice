package sort;

public class Sort {
    public static void main(String[] args) {
        int[] nums ={49,38,65,97,10,67,13,27};
        printNums(bubleSort(nums));
    }
    /**
     * 冒泡排序
     * 1. 把第一个与第二个比较，若第一个较大，则改变顺序，第二个与第三个比较，同理，直到最后，最大的关键字放在最后一位
     * 2. 第二趟进行同样操作，直到被安排在n-1个位置
     * 3. 若在某趟没有交换，说明完成排序
     */
   static int[] bubleSort(int[] a){
        int flag =1 ;//用来标记是否交换
        int m=a.length-1; //因为有i+1 防止数组越界
        while(m>0 && flag==1){
            flag=0; //flag为0 如果没有交换，则会停止排序
            for (int i = 0; i < m; i++) {
                if (a[i]>a[i+1]){
                    flag=1;
                    int t=a[i];
                    a[i]=a[i+1];
                    a[i+1]=t;
                }
            }
            m--; // 每次一个数上浮之后从下一个数开始
        }
        return a;
    }

    /**
     * 快速排序 感觉是
     *
     */

    /**
     * 打印数组
     * @param a
     */
   static void printNums(int[] a){
       for (int j : a) {
           System.out.println(j);
       }
    }

}
