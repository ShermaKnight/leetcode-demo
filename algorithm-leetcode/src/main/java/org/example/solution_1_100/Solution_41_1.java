package org.example.solution_1_100;

import com.google.common.base.Preconditions;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/
 */
public class Solution_41_1 {

    public static void main(String[] args) {
        Preconditions.checkArgument(3 == firstMissingPositive(new int[]{1, 2, 0}));
        Preconditions.checkArgument(2 == firstMissingPositive(new int[]{3, 4, -1, 1}));
        Preconditions.checkArgument(1 == firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        Preconditions.checkArgument(1 == firstMissingPositive(new int[]{-1, -2, 0}));
    }

    public static int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // 缓存数据
        int size = nums.length;
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < size; i++) {
            cache.put(nums[i], i);
        }

        // 寻找最小正整数
        for (int i = 1; i <= size; i++) {
            if (!cache.containsKey(i)) {
                return i;
            }
        }
        return size + 1;
    }
}
