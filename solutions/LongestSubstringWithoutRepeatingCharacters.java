import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        
        // String problem1 = "abcabcbb";
        // System.out.println(problem1);

        // System.out.println(solve_bruteforce(problem1));


        // String problem2 = "bbbbb";
        // System.out.println(solve_bruteforce(problem2));
        
        // String problem3 = "pwwkew";
        // System.out.println(solve_bruteforce(problem3));

        String problem4 = " ";
        System.out.println(solve_bruteforce(problem4));

    }

    public static int solve_bruteforce(String s) {
        
        int longest = 0;
        for (int start = 0; start < s.length(); start++) {
            Set<Character> set = new HashSet<>();
            for (int i = start; i < s.length(); i++) {
                if (!set.contains(s.charAt(i))) {
                    System.out.println("hello");
                    set.add(s.charAt(i));
                    if (set.size() > longest) {
                        longest = set.size();
                    }
                } else {
                    break;
                }
            }
        }

        return longest;
    }
}