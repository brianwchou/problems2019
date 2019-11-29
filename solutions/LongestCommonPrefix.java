import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] problem1 = new String[]{"flower","flow","flight"};

        System.out.println(solve(problem1));
    }
    
    public static String solve(String[] strs) {
        StringBuilder sb = new StringBuilder();
        
        if (strs.length == 0) {
            return sb.toString();
        }

        // be sure to mark what happens when the array is empty
        String first = strs[0];
        
        // for each of the characters within the first string
        for (int i = 0; i < first.length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                // check each string at the loaction of
                if (i >= strs[j].length()) {
                    return sb.toString();
                }
                
                if (first.charAt(i) != strs[j].charAt(i)) {
                    return sb.toString();
                }
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}