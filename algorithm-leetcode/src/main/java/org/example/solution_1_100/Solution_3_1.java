package org.example.solution_1_100;

import com.google.common.base.Preconditions;

import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
@SuppressWarnings("all")
public class Solution_3_1 {

    public static void main(String[] args) {
        Preconditions.checkArgument(3 == lengthOfLongestSubstring("abcabcbb"));
        Preconditions.checkArgument(2 == lengthOfLongestSubstring("bcbb"));
        Preconditions.checkArgument(3 == lengthOfLongestSubstring("pwwkew"));
        Preconditions.checkArgument(1 == lengthOfLongestSubstring("aa"));
        Preconditions.checkArgument(4 == lengthOfLongestSubstring("abcd"));
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int from = 0;
        int to = 1;
        int max = 0;
        HashMap<Character, Integer> cache = new HashMap<>();
        cache.put(s.charAt(from), 0);
        while (to < s.length()) {
            int l = 0;
            if (cache.containsKey(s.charAt(to))) {
                int cut = cache.get(s.charAt(to));
                while (from <= cut) {
                    cache.remove(s.charAt(from));
                    from++;
                }
            }
            cache.put(s.charAt(to), to);
            max = Math.max(to - from + 1, max);
            to++;
        }
        return max;
    }
}
