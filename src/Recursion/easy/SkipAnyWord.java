package Recursion.easy;

public class SkipAnyWord {
    public static void main(String[] args) {
        System.out.println(approach1("asdapplenoor"));
    }

    private static String approach1(String input) {
        if(input.isEmpty()){
            return input;
        }
        if(input.startsWith("apple")){
            return approach1(input.substring(5));
        }else{
            return (input.charAt(0)+approach1(input.substring(1)));
        }
    }
}
