import java.util.ArrayList;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        while (list.size()!=0) {
            list.remove(0);
        }
    }
}