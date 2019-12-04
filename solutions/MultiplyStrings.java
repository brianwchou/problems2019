import java.util.LinkedList;
import java.util.List;

public class MultiplyStrings {
    public static void main(String[] args) {
        String a = "9999";
        String b = "0";

        System.out.println(solve(a, b));
    }

    public static String solve(String a, String b) {
        if (a.equals("0") || b.equals("0"))
            return "0";

        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 0; i < a.length(); i++) {
            for (int j = 0; j < b.length(); j++) {

                int total = Character.getNumericValue(a.charAt(i));
                total *= Character.getNumericValue(b.charAt(j));

                if (list.size() <= i + j) {
                    list.add(total);
                } else {
                    list.set(i + j,list.get(i + j) + total);
                }
            }
        }

        int carry = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int current = list.get(i);
            current += carry;
            
            carry = current / 10;
            current = current % 10;

            list.set(i, current);
        }

        if (carry > 0) {
            list.addFirst(carry);
        }

        return listToString(list);
    }

    public static String listToString(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int value : list) {
            sb.append(value);
        }
        return sb.toString();
    }
}