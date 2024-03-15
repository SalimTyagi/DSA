package Iteration.medium;

import java.util.ArrayList;
import java.util.List;

public class SubSet {
    public static void main(String[] args) {
        List<List<Integer>> ans= subset(new int[]{1,2,3});
        for (List<Integer> list : ans){
            System.out.println(list);
        }
    }

    private static List<List<Integer>> subset(int[] arr) {
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());

        for(int num : arr){
            int n = outer.size();
            for (int i = 0; i < n; i++) {
                List<Integer> inner = new ArrayList<>(outer.get(i));
                inner.add(num);
                outer.add(inner);
            }
        }
        return outer;
    }
}
