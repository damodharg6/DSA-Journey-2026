package Arrays;
// Problem: Two Sum
// Goal: Find two indices such that nums[i] + nums[j] = target

// Approach 1: Brute Force
// Time: O(n^2), Space: O(1)

// Approach 2: Sorting + Two Pointer
// Time: O(n log n), Space: O(n)

// Approach 3: HashMap (Optimal)
// Time: O(n), Space: O(n)

import java.util.*;

public class TwoSum {

    // 🔹 Approach 1: Brute Force
    public static int[] twoSumBrute(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{-1, -1};
    }

    // 🔹 Approach 2: Sorting + Two Pointer
    public static int[] twoSumSorted(int[] nums, int target) {
        int n = nums.length;

        int[][] arr = new int[n][2];
        for(int i = 0; i < n; i++) {
            arr[i][0] = nums[i];
            arr[i][1] = i;
        }

        Arrays.sort(arr, Comparator.comparingInt(a -> a[0]));

        int left = 0, right = n - 1;

        while(left < right) {
            int sum = arr[left][0] + arr[right][0];

            if(sum == target) {
                return new int[]{arr[left][1], arr[right][1]};
            } else if(sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return new int[]{-1, -1};
    }

    // 🔹 Approach 3: HashMap (Optimal)
    public static int[] twoSumOptimal(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];

            if(map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }

            map.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    // 🔹 Helper method for clean output
    public static void printResult(String approach, int[] result) {
        System.out.println(approach + ": " + result[0] + ", " + result[1]);
    }

    // 🔹 Main method
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;

        printResult("Brute Force", twoSumBrute(nums, target));
        printResult("Sorting + Two Pointer", twoSumSorted(nums, target));
        printResult("HashMap (Optimal)", twoSumOptimal(nums, target));
    }
}