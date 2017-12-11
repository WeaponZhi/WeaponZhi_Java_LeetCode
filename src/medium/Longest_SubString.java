package medium;

import java.util.HashMap;

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

    public static void main(String[] args) {
        Longest_SubString test = new Longest_SubString();
        System.out.println(test.myLengthOfLongestSubstring("abba"));
        System.out.println(test.myLengthOfLongestSubstring("dsvd"));
        System.out.println(test.myLengthOfLongestSubstring("c"));
        System.out.println(test.myLengthOfLongestSubstring("abcabcbb"));
        System.out.println(test.myLengthOfLongestSubstring("bbbbb"));
        System.out.println(test.myLengthOfLongestSubstring("pwwkew"));
    }
}
