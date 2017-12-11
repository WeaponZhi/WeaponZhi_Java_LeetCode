package medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 */
public class Longest_SubString {
    public int myLengthOfLongestSubstring(String s) {
        if ("".equals(s) || s == null) {
            return 0;
        }
        char[] charArray = s.toCharArray();
        int startIndex = 0, endIndex = 0, longestCount = 1;
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < charArray.length; i++) {
            char indexChar = charArray[i];
            if (map.containsKey(indexChar) && map.get(indexChar) >= startIndex) {
                if (i - startIndex > longestCount) {
                    longestCount = i - startIndex;
                    if (i == charArray.length-1){
                        return longestCount;
                    }
                }
                startIndex = map.get(indexChar) + 1;
            }
            map.put(indexChar, i);
            endIndex = i;
        }
        if (endIndex - startIndex + 1 > longestCount) {
            longestCount = endIndex - startIndex + 1;
        }
        return longestCount;
    }

    public int wellSolution(String s){
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Longest_SubString test = new Longest_SubString();
        System.out.println(test.myLengthOfLongestSubstring("abba"));
        System.out.println(test.myLengthOfLongestSubstring("dsvd"));
        System.out.println(test.myLengthOfLongestSubstring("c"));
        System.out.println(test.myLengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.myLengthOfLongestSubstring("bbbbb"));
        System.out.println(test.myLengthOfLongestSubstring("pwwkew"));

        System.out.println(test.wellSolution("dsvd"));
    }
}
