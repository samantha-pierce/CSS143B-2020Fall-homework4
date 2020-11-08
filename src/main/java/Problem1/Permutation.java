package Problem1;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static List<List<Integer>> permute(int[] nums) {
        // homework
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            result.add(new ArrayList<>());
        } else {
            permute(nums, 0, result);
        }
        return result;
    }

    private static void permute(int[] nums, int position, List<List<Integer>> result) {
        // stopping condition
        if (position == nums.length - 1) {
            List<Integer> oneResult = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                oneResult.add(nums[i]);
            }
            result.add(oneResult);
            return;
        }
        for (int i = position; i < nums.length; i++) {
            // put number at position in the front
            swap(nums, i, position);
            // call the same private permute with position+1
            permute(nums, position + 1, result);
            // put the number back to its original position
            swap(nums, i, position);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

// credit to https://www.programcreek.com/2013/02/leetcode-permutations-java/ for help with code
