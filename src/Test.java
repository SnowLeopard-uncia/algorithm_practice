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
//            list.remove(0);
//        }
        int[] a ={7,2,1};
        findBiggest(a,3,2);
    }

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


}
