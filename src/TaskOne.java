import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        // Task #1
        System.out.println(Arrays.toString(targetSumHashMap(new int[]{3, 8, 15, 17}, 23)));
        System.out.println(Arrays.toString(targetSumBruteForce(new int[]{3, 4}, 7)));
        // Task #2
        System.out.println(ifDuplicatesSort(new int[]{4, 5, 6, 6, 8}));
        System.out.println(ifDuplicatesBruteForce(new int[]{4, 5, 6, 7, 8}));
    }
    //HashMap O(n)
    public static int[] targetSumHashMap(int[] array, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (hashmap.containsKey(target - array[i])) {
                result[0] = hashmap.get(target - array[i]);
                result[1] = i;
            }
            hashmap.put(array[i], i);
        }
        return result;
    }
    //BruteForce O(n^2)
    public static int[] targetSumBruteForce(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    // Arrays Sort O(nlogn)
    public static boolean ifDuplicatesSort(int[] array) {
        Arrays.sort(array);
        int num = array[0];
        for (int i = 1; i < array.length; i++) {
            if (num == array[i])
                return true;
            else
                num = array[i];
        }
        return false;
    }
    //BruteForce O(n^2)
    public static boolean ifDuplicatesBruteForce(int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == array[j])
                    return true;
            }
        }
        return false;
    }
}
