package sort;

import com.sun.media.sound.RIFFInvalidFormatException;

public class Sort {
    public static void main(String[] args) {
        int[] nums ={49,38,65,97,10,67,13,27};
        int[] num = {5,2,7,1,6};
//        printNums(bubleSort(nums));
//        printNums(quickSort(num,0,num.length-1));
//        practiceBubble(nums);
//        printNums(practiceQuick(num,0,num.length-1));
//        printNums(practice2(num,0, num.length-1));
        printNums(SelectSort(num));
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
     * 打印数组
     * @param a
     */
   static void printNums(int[] a){
       for (int j : a) {
           System.out.println(j);
       }
    }

    /**
     * 快速排序
     * 1. 选一个轴，通常第一个
     * 2. 一趟排序后，轴枢左边都比轴小，轴枢右边都比轴大
     * 3. 递归对左右表重复上述过程
     * 【很像二叉树前序】
     */
    public static int[] quickSort(int[] a, int low,int high){
        if (low<high){
            int pivotPos=partition(a,low,high);
            quickSort(a,low,pivotPos-1);
            quickSort(a,pivotPos+1,high);
        }
        return a;
    }

    //一趟划分
    public static int partition(int[] a, int low,int high){
        int pivot = a[low]; //第一个元素作为轴枢
        while (low<high){
            while (low<high && a[high]>=pivot){ //这里是想找比pivot小的坐标
                --high;
            }
            a[low] =a[high]; //比轴枢小的都移到左边
            while(low<high && a[low]<=pivot){ //这里是想找比pivot大的坐标
                ++low;
            }
            a[high]=a[low];//比轴枢大的移到右边
        }
        a[low]=pivot; //轴枢最后存放位置
        return low; //返回轴枢存放的最终位置
    }

    /**
     * 归并排序
     */

    /**
     * 冒泡排序 练习版
     */
    public static void practiceBubble(int a[]){
        int flag=1; //用来标记是否发生了交换 冒泡结束的条件是一趟下来再也没有交换
        int m=a.length-1; //这里要记得
        while((m>0) && (flag==1)){
            flag=0;
            for (int i = 0; i < m; i++) {
                if (a[i]>a[i+1]){
                    int temp = a[i];
                    a[i]=a[i+1];
                    a[i+1]=temp;
                    //发生了交换
                    flag=1;
                }
            }
            m--; //一趟排序完成
        }
        for (int j : a) {
            System.out.println(j);
        }
    }

    /**
     * 快速排序 练习版
     */
    public static int[] practiceQuick(int a[],int low,int high){
//        low = 0;  //不要，不然白递归了好吗
//        high=a.length-1;
        if (low<high){  //if不是while
            int pivot = practicePartition(a,low,high); //每次递归找轴枢，然后一次排序完
            practiceQuick(a,low,pivot-1); //左子表  //low和high 要注意参数
            practiceQuick(a,pivot+1,high); //右子表
        }
        return a;
    }

    /**
     * 快排一趟排序
     * @param a
     * @param high
     * @param low
     * @return 返回轴枢位置
     */
    public static int practicePartition(int[]a,int low,int high){
        int pivot =a[low]; //轴枢
        while(low<high){
            while (low<high && a[high]>=pivot){   //这里搞反了   //low<high && 这个判断很有必要，不然会有数组越界
                high--;   //这里是想找比pivot小的坐标
            }
            a[low] = a[high]; //比轴枢记录小的移到低端
            while (low<high && a[low]<=pivot){  //这里搞反了
                low++;  //这里是想找比pivot大的坐标
            }
            a[high]=a[low];//比轴枢记录大的移到高端
        }
        a[low]=pivot;  //轴枢最后存放位置
        return low;  //返回轴枢的位置
    }

    /**
     * 快速排序 练习版2
     */

    public static int[] practice2(int[] a, int low, int high){
        if (low<high){
            int pivot = partition2(a,low,high);
            partition2(a,low,pivot-1);
            partition2(a,pivot+1,high);
        }
        return a;
    }

    //一趟快排 返回轴枢下标
    public static int partition2(int[] a, int low, int high){
        int pivot = a[low];

        while(low<high){
            while (low<high && a[high]>=pivot){
                high--; //主要是找出比pivot小的坐标
            }
            a[low] = a[high];
            while (low<high && a[low]<=pivot){
                low++;
            }
            a[high]=a[low];
        }
        a[low] = pivot;
        return low;
    }

    /**
     * 选择排序 直接选择排序
     */
    public static int[] SelectSort(int[] a){
        int min;
        for (int i = 0; i < a.length; i++) {
            min=i;
            for (int j = i+1; j < a.length; j++) {
                if (a[j]<a[min]) min=j; //更新最小的元素
            }
            if (min!=i){
                int t = a[i];
                a[i] = a[min];
                a[min] = t;
            }
        }
        return a;
    }

    /**
     * 堆排序
     */

    //调整堆
    public void HeapAdjust(int[] a,int s, int m){
        //a[s+1 ...m]是堆 将a[s...m]调整为以r[s]为根的大根堆
        int rc = a[s];
        for (int j=2*s;j<=m; j*=2){  //沿着key比较大的孩子结点往下筛选
            if (j<m && a[j]<a[j+1]){
                j++;
            }

        }
    }
}
