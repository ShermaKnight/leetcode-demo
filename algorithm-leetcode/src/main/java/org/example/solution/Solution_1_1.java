package org.example.solution;

import com.google.common.base.Preconditions;
import org.example.util.CheckUtil;

/**
 * https://leetcode-cn.com/problems/two-sum/
 * 两数之和
 */
@SuppressWarnings("all")
public class Solution_1_1 {

    public static void main(String[] args) {
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1}));
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2}));
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{3, 3}, 6), new int[]{0, 1}));
        Preconditions.checkArgument(CheckUtil.checkArrays(twoSum(new int[]{2, 11, 15}, 9), null));
    }

    /**
     * 思路：遍历数组中是否存在目标值减去当前元素值
     *
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum(int[] nums, int target) {
        if (nums.length < 2) {
            return null;
        }
        for (int i = 0; i < nums.length; i++) {
            int number = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == number) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
