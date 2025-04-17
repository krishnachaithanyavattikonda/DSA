package MostAsked.Strings;

import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs= {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs) {
        StringBuffer sb=new StringBuffer();
        Arrays.sort(strs);
        String first=strs[0];
        String last=strs[strs.length-1];
        for(int i=0;i<Math.min(first.length(),last.length());i++){
            if(first.charAt(i)!=last.charAt(i)){
                return sb.toString();
            }
            sb.append(first.charAt(i));
        }
        return sb.toString();
    }
}
