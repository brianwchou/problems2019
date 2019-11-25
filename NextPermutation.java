import java.util.Arrays;

public class NextPermutation {

    public static void main(String[] args) {
        int[] array = {5, 4, 7, 5, 3, 2};
        // 5, 4, 7, 5, 3, 2

        int[] solution = nextPermutation(array);
        System.out.println(Arrays.toString(solution));
        
        
        int n = 25;
        while (n-- > 0) {
            System.out.println(Arrays.toString(solution));
            solution = nextPermutation(array);
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int i = nums.length - 1;

        while (i >= 0) {
            int min = findMin(nums, nums[i], i + 1);
            if (min > 0) {
                swap(nums, i, min);
                break;
            }
            i--;
        }

        sectionedBubbleSort(nums, i + 1);
        return nums;
    }

    public static int findMin(int[] array, int target, int i) { 
        int current = - 1;
        while (i < array.length) {
            if (target < array[i]) {// target less than current value
                if (current < 0) { // find first bigger than target
                    current = i;
                } else if (array[current] > array[i]) { // compare current with i to find minimum
                    current = i;
                }
            }
            i++;
        }

        return current;
    }

    public static void swap(int[] array, int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    public static void sectionedBubbleSort(int[] array, int start) {
        for (int i = start; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]){
                    swap(array, i, j);
                }
            }
        }
    }
}