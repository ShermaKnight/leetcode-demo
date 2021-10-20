package org.example.solution_1_100;

import com.google.common.base.Preconditions;
import org.example.util.CheckUtil;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/two-sum/
 */
@SuppressWarnings("all")
public class Solution_1_2 {

    public static void main(String[] args) {
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{2, 11, 15}, 9), null));
    }

    /**
     * 思路：使用map缓存遍历过的值，查找是否存在目标值减去当前值的key
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        HashMap<Integer, Integer> cache = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (cache.containsKey(target - nums[i])) {
                return new int[]{cache.get(target - nums[i]), i};
            }
            cache.put(nums[i], i);
        }
        return null;
    }
}
