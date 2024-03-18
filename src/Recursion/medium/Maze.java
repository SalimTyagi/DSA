package Recursion.medium;

import java.util.ArrayList;
import java.util.List;

public class Maze {
    public static void main(String[] args) {
        // when we move right(H) and down(V) only
       // System.out.println(mazeCount(3,3));
//        mazePath("",3,3);
//        System.out.println(mazePathReturn("",3,3));

        //if we can move H,V,diagonally then
        System.out.println(mazePathDiagonalAlsoReturn("",3,3));
    }

    private static int mazeCount(int r, int c) {
        if(r==1 || c==1){
            return 1;
        }
        int left = mazeCount(r-1,c);
        int right = mazeCount(r,c-1);

        return (left+right);

    }

    private static void mazePath(String p, int r, int c) {
        if(r==1 && c==1){
            System.out.println(p);
            return;
        }
        if(r>1){
            mazePath(p+"D",r-1,c);
        }
        if(c>1){
            mazePath(p+"R",r,c-1);
        }

    }

    private static List<String> mazePathReturn(String p, int r, int c) {
        if(r==1 && c==1){
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }

        List<String> list = new ArrayList<>();
        if(r>1){
            list.addAll(mazePathReturn(p+"D",r-1,c));
        }

        if(c>1){
            list.addAll(mazePathReturn(p+"R",r,c-1));
        }
        return list;

    }

    private static List<String> mazePathDiagonalAlsoReturn(String p, int r, int c) {
        if(r==1 && c==1){
            List<String> ans = new ArrayList<>();
            ans.add(p);
            return ans;
        }
        List<String> list = new ArrayList<>();

        if(r>1){
            list.addAll(mazePathDiagonalAlsoReturn(p+"H",r-1,c));
        }
        if(c>1){
            list.addAll(mazePathDiagonalAlsoReturn(p+"V",r,c-1));
        }
        if(r>1 && c>1){
            list.addAll(mazePathDiagonalAlsoReturn(p+"D",r-1,c-1));
        }
        return list;
    }


}
