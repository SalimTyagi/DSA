package Leetcode;

import java.util.ArrayList;
import java.util.List;

public class LetterCombination_17 {
    public static void main(String[] args) {
        //In Leetcode package class name is followed by leetcode question number.
        // recursion question
       pad("","12");
        System.out.println(padRet("","12"));
    }

    private static void pad(String p, String up) {
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        int digit = up.charAt(0)-'0';
        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char current = (char)('a'+i);
            pad(p+current,up.substring(1));
        }
    }

    private static List<String> padRet(String p, String up) {
        if(up.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(p);
            return list;
        }
        int digit = up.charAt(0)-'0';
        List<String> ans = new ArrayList<>();

        for (int i = (digit-1)*3; i < digit*3 ; i++) {
            char current = (char)('a'+i);
            ans.addAll(padRet(p+current,up.substring(1)));
        }
        return ans;
    }
}
