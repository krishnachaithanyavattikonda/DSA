package MostAsked.Strings;

import java.util.HashSet;

public class LongestSubStringWithoutRepeatingChars {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

    static int lengthOfLongestSubstring(String s) {
        int left=0;
        int max_length=0;
        HashSet<Character> charSet=new HashSet<>();

        for(int right=0;right<s.length();right++){

            while(charSet.contains(s.charAt(right))){
                charSet.remove(s.charAt(left));
                left++;
            }

            charSet.add(s.charAt(right));
            max_length=Math.max(max_length,right-left+1);

        }
        return max_length;
    }
}
