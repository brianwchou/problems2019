public class SearchRotatedArray {
    public static void main(String[] args) {
        int[] problem = new int[]{4,5,6,7,0,1,2};
        
    }

    public static int solve() {
        return 0;
    }

    public static int rotationIndexSearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {

            int mid = (left + right) / 2;
            if (target < array[mid]) {
                right -= mid + 1;
            } else if (target > array[mid]) {
                left += mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (target < array[mid]) {
                right -= mid + 1;
            } else if (target > array[mid]) {
                left += mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}