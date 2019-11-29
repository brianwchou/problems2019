import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] problem = {2, 7, 11, 15};
        int[] answer = solve(problem, 9);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solve(int[] nums, int target) {
        HashMap<Integer, Integer> table = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (!table.containsKey(target - nums[i])) {
                table.put(nums[i] , i); 
            } else {
                int j = table.get(target - nums[i]);
                return new int[]{i, j};
            }
        }

        return new int[0];
    }
}