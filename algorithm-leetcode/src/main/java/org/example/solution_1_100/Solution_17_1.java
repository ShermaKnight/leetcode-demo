package org.example.solution_1_100;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class Solution_17_1 {

    private static HashMap<Integer, List<String>> cache = new HashMap<Integer, List<String>>(){
        {
            put(2, Arrays.asList(new String[]{"a", "b", "c"}));
            put(3, Arrays.asList(new String[]{"d", "e", "f"}));
            put(4, Arrays.asList(new String[]{"g", "h", "i"}));
            put(5, Arrays.asList(new String[]{"j", "k", "l"}));
            put(6, Arrays.asList(new String[]{"m", "n", "o"}));
            put(7, Arrays.asList(new String[]{"p", "q", "r", "s"}));
            put(8, Arrays.asList(new String[]{"t", "u", "v"}));
            put(9, Arrays.asList(new String[]{"w", "x", "y", "z"}));
        }
    };

    public static void main(String[] args) {
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("275"));
    }

    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.EMPTY_LIST;
        }
        if (digits.length() == 1) {
            return cache.get(Integer.valueOf(String.valueOf(digits.charAt(0))));
        }
        List<String> list = new ArrayList<>();
        backtrack(list, digits, 0, new StringBuffer());
        return list;
    }

    private static void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        } else {
            char digit = digits.charAt(index);
            List<String> letters = cache.get(Integer.valueOf(String.valueOf(digit)));
            for (String letter : letters) {
                combination.append(letter);
                backtrack(combinations, digits, index + 1, combination);
                combination.deleteCharAt(index);
            }
        }
    }
}
