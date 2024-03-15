package Recursion.easy;

public class SkipAnyChar {
    public static void main(String[] args) {
        approach1("","baccad");
        System.out.println(approach2("abbbacsa"));
    }

    private static void approach1(String output, String input) {
        if(input.isEmpty()){
            System.out.println(output);
            return;
        }
        char ch = input.charAt(0);

        if(ch=='a'){
            approach1(output,input.substring(1));
        }else {
            approach1(output+ch,input.substring(1));
        }
    }

    private static String approach2(String input) {
        if(input.isEmpty()){
            return input;
        }

        char ch = input.charAt(0);

        if(ch=='a'){
            return approach2(input.substring(1));
        }else{
            return (ch + approach2(input.substring(1)));
        }
    }
}
