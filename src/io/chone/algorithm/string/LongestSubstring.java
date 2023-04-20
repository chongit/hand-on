package io.chone.algorithm.string;

import java.util.HashMap;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.length() < 2) return s.length();
        int i = 0, j = 0;
        int ans = 0;
        int[] table = new int[129];
        while (i <  s.length() && j < s.length()) {
            if (table[s.charAt(j)]==0) {
                table[s.charAt(j)] = 1;
                j++;
                ans = Math.max(ans, j - i);
            } else {
                table[s.charAt(i)] = 0;
                i++;
            }
        }
        return ans;
    }

    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;
        int[] index = new int[128];
        for (int j = 0, i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            ans = Math.max(ans, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new LongestSubstring().lengthOfLongestSubstring1("dvdf"));
//        System.out.println(new LongestSubstring().lengthOfLongestSubstring("au"));
//        System.out.println(new LongestSubstring().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new LongestSubstring().lengthOfLongestSubstring("bbbbb"));
//        System.out.println(new LongestSubstring().lengthOfLongestSubstring("pwwkew"));
    }
}
