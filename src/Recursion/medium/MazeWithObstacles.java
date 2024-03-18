package Recursion.medium;

public class MazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] board = {
                {true,true,true},
                {true,false,true},
                {true,true,true}
        };
        mazeObstaclesPath("",board,0,0);
    }

    private static void mazeObstaclesPath(String p , boolean[][] board, int r, int c) {
        if(r==board.length-1 && c==board[0].length-1){
            System.out.println(p);
            return;
        }
        if(!board[r][c]){
            return;
        }
        if(r<board.length-1){
            mazeObstaclesPath(p+"R",board,r+1,c);
        }
        if(c<board[0].length-1){
            mazeObstaclesPath(p+"D",board,r,c+1);
        }
    }
}
