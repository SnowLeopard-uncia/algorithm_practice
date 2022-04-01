package Search;

public class Main {
    public static void main(String[] args) {
        int arr[]={-1,1,2,3,4,5,6,7,8,9,12,13,14,15,16,17,23,34,45,56};
        System.out.println(searchSeq(arr,5));

        System.out.println(searchSeqImprove(arr,5));

        System.out.println(searchBin(arr,12));

       int result =  searchBinRecursion(arr,9,arr[1],arr.length-1);
        System.out.println("result: "+result);
        /*
        int i=1,j=1;
        //结果：i：1，j：0 【i--是先取值后减 --j是先减后取值】，会提示说i--更改的值不会被使用
        System.out.println("i"+(i--)+"j"+(--j));

         */
    }

//在顺序表中查找关键字为key的数据元素，找到则返回相应位置，否则为0
    public static int searchSeq(int[] arr, int key){
        for (int i = arr.length-1; i>=1 ; i--) {
            if (arr[i]==key) return i;
        }
        return 0;
    }
    //改进：设置0位是哨岗 减去了数组越界的判断
    public static int searchSeqImprove(int[] arr, int key){
        arr[0]=key;
        int i;
        for ( i = arr.length-1; arr[i]!=key ; i--);
        return i;
    }

    //二分查找
    public static int searchBin(int[] arr, int key){
        int low =1;
        int high = arr.length-1; //查找区间初值
        while(low<=high){
            int mid = (low+high)/2;
            if (key==arr[mid]) return mid;
            else if (key>mid) low=mid+1; //在前一个子表进行查找
            else high=mid-1; // 在后一个子表查找
        }
        return 0; //查找不到元素
    }

    //二分查找 递归版
    public static int searchBinRecursion(int[] arr, int key, int low, int high){
        int mid =(high+low)/2;
        if (key==arr[mid]) return mid; // 找到了
        else if (low>high) return 0; //找不到
        else if (key>mid) return searchBinRecursion(arr,key,mid+1,high);//在前一个子表进行查找
        else return searchBinRecursion(arr,key,low,mid-1);// 在后一个子表查找
    }

}
