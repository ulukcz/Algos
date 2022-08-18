import java.util.*;

public class TaskOne {
    public static void main(String[] args) {
        // Task #1
        System.out.println(Arrays.toString(targetSumHashMap(new int[]{3, 8, 15, 17}, 23)));
        System.out.println(Arrays.toString(targetSumBruteForce(new int[]{3, 4}, 7)));
        // Task #2
        System.out.println(ifDuplicatesList(new int[]{4, 5, 6, 6, 8}));
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

    // ArrayList O(n)
    public static boolean ifDuplicatesList(int[] array) {
        List<Integer> list = new ArrayList<>();
        for (int num : array) {
            if (list.contains(num)) {
                return true;
            }
            list.add(num);
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
