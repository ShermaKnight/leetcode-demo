package org.example.solution_500_600;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class Solution_524_1 {

    public static void main(String[] args) {
        Preconditions.checkArgument("apple".equalsIgnoreCase(findLongestWord("abpcplea", Stream.of(
                "ale", "apple", "monkey", "plea"
        ).collect(Collectors.toList()))));
        Preconditions.checkArgument("a".equalsIgnoreCase(findLongestWord("abpcplea", Stream.of(
                "a", "b", "c"
        ).collect(Collectors.toList()))));
        Preconditions.checkArgument("apple".equalsIgnoreCase(findLongestWord("abpcplea", Stream.of(
                "ale", "apple", "monkey", "plea", "abpcplaaa", "abpcllllll", "abccclllpppeeaaaa"
        ).collect(Collectors.toList()))));
    }

    public static String findLongestWord(String s, List<String> dictionary) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int max = 0;
        HashMap<Integer, List<String>> cache = new HashMap<>();
        for (String d : dictionary) {
            if (d == null || d.length() == 0) {
                continue;
            }
            int i = 0;
            int j = 0;
            boolean label = true;
            while (i < d.length()) {
                while (j < s.length() && d.charAt(i) != s.charAt(j)) {
                    j++;
                }
                if (j < s.length() && d.charAt(i) == s.charAt(j)) {
                    i++;
                    j++;
                } else {
                    label = false;
                    break;
                }
            }
            if (i == d.length() && label) {
                int l = d.length();
                if (cache.containsKey(l)) {
                    cache.get(l).add(d);
                } else {
                    List<String> ds = Stream.of(d).collect(Collectors.toList());
                    cache.put(l, ds);
                }
                max = Math.max(max, l);
            }
        }
        System.out.println(cache);
        if (cache.size() != 0) {
            List<String> list = cache.get(max);
            return list.stream().sorted().findFirst().get();
        }
        return "";
    }
}
