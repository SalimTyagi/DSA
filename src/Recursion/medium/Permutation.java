package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class Permutation {
    public static void main(String[] args) {
        //approach1("","abc");
        //System.out.println(approach2("","abc"));
        System.out.println(countPermutation("","abcdef"));
    }

    private static void approach1(String output, String input) {
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }

        char current = input.charAt(0);
        for (int i = 0; i <= output.length(); i++) {
            String f = output.substring(0,i);
            String s = output.substring(i);
            approach1(f+current+s,input.substring(1));
        }
    }

    private static List<String> approach2(String output, String input) {
        if(input.isEmpty()){
            List<String> list = new ArrayList<>();
            list.add(output);
            return list;
        }
        char current = input.charAt(0);
        List<String> ans = new ArrayList<>();
        for (int i = 0; i <= output.length(); i++) {
            String f = output.substring(0,i);
            String s = output.substring(i);
            ans.addAll(approach2(f+current+s,input.substring(1)));
        }
        return ans;
    }
    private static int countPermutation(String output, String input){
        if(input.isEmpty()){
            return 1;
        }
        char ch = input.charAt(0);
        int count = 0;

        for (int i = 0; i <= output.length(); i++) {
            String f = output.substring(0,i);
            String s = output.substring(i);
            count = count+ countPermutation(f+ch+s,input.substring(1));
        }
        return count;
    }
}
