package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class SubSequence {
    public static void main(String[] args) {
        //subSequence is for String questions
        //subsets is for array questions
       // approach1("","abc");
        System.out.println(approach2("","abc"));
    }

    private static void approach1(String output, String input) {
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
        char current = input.charAt(0);
        approach1(output+current,input.substring(1));
        approach1(output,input.substring(1));

        //or
//        approach1(output,input.substring(1));
//        approach1(output+current,input.substring(1));

    }

    private static List<String> approach2(String output, String input) {
        if(input.isEmpty()){
            List<String> ans = new ArrayList<>();
            ans.add(output);
            return ans;
        }
        char current = input.charAt(0);
        List<String> left = approach2(output,input.substring(1));
        List<String> right = approach2(output+current,input.substring(1));
        left.addAll(right);
        return left;
    }
}
