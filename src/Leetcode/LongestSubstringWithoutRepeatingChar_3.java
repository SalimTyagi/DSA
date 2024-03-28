package Leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingChar_3 {
    public static void main(String[] args) {
        String s =  "abcabcbb";
        System.out.println(lengthOfLongestansing(s));
    }

    public static int lengthOfLongestansing(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int start = 0;

        for (int end = 0; end < s.length(); end++) {
            char c = s.charAt(end);
            if (map.containsKey(c)) {
                // Update the start index to the next character after the repeated character's last occurrence
                start = Math.max(start, map.get(c) + 1);
            }
            map.put(c, end); // Update the index of the current character
            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }

    static int approach1(String str){

        // 1st way
        if(str.isEmpty()){
            return 0;
        }else if(str.length()==1){
            return 1;
        }

        int maxCount = -1;
        String ans = "";

        for(char ch : str.toCharArray()){
            String current = String.valueOf(ch);
            if(ans.contains(current)){
                ans = ans.substring(ans.indexOf(current)+1);
            }
            ans+=current;
            maxCount = Math.max(ans.length(),maxCount);
        }

        return maxCount;
    }
}
