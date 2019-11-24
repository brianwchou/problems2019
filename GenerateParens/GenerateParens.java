import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class GenerateParens {
    
    public static void main(String[] args) {
        ArrayList<String> list = topDown(4);
        System.out.println(list.toString());
    }


    public static ArrayList<String> topDown(int n) {

        ArrayList<String> aList = new ArrayList<>();
        topDown(aList, "", n, n);
        return aList;
    }

    public static void topDown(List<String> list, String gen, int left, int right) {
        if (left == 0 && right == 0) {
            list.add(gen);
            return;
        }

        if (left > 0) {
            topDown(list, gen + "(", left - 1, right);
        }

        if (left < right && right > 0) {
            topDown(list, gen + ")", left, right - 1);
        }        
    }
}