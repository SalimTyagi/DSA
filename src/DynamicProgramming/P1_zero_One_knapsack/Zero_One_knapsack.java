package DynamicProgramming.P1_zero_One_knapsack;

public class Zero_One_knapsack {
    public static void main(String[] args) {
        int[] wt  = {1,3,4,5};
        int[] val = {1,4,5,7};
        int n = wt.length;
        int W = 7;
        System.out.println(zeroOneKnapsack_WithRecursion(wt,val,W,n));
        System.out.println(zeroOneKnapsack_WithMemoizationDP(wt,val,W,n));
        System.out.println(zeroOneKnapsack_WithTopDownDP(wt,val,W,n));
        /*
        zeroOneKnapsack_WithMemoizationDP() is also a Dp solution;
        zeroOneKnapsack_WithTopDownDP() this is topDown Approach and this is also Dp solution;
         */
    }

    private static int zeroOneKnapsack_WithRecursion(int[] wt, int[] val, int w, int n) {

        if(w==0 || n==0){
            return 0;
        }

        if(wt[n-1]>w){
            return zeroOneKnapsack_WithRecursion(wt,val,w,n-1);
        }

        return Math.max(val[n-1]+zeroOneKnapsack_WithRecursion(wt,val,w-wt[n-1],n-1)
                ,zeroOneKnapsack_WithRecursion(wt,val,w,n-1));

    }

    private static int zeroOneKnapsack_WithMemoizationDP(int[] wt, int[] val, int w, int n) {

        int[][] dp = new int[n+1][w+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w+1; j++) {
                dp[i][j] = -1;
            }
        }

        if(w==0 || n==0) return 0;

        if(dp[n][w]!=-1) return dp[n][w];

        if(wt[n-1]>w){
            return dp[n][w] = zeroOneKnapsack_WithMemoizationDP(wt,val,w,n-1);
        }

        return dp[n][w] = Math.max(val[n-1] + zeroOneKnapsack_WithMemoizationDP(wt,val,w-wt[n-1],n-1),
                zeroOneKnapsack_WithMemoizationDP(wt,val,w,n-1));
    }

    private static int zeroOneKnapsack_WithTopDownDP(int[] wt, int[] val, int w, int n) {

        int[][] dp = new int[n+1][w+1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < w + 1; j++) {
               if(i==0 || j==0){
                   dp[i][j] = 0;
               }
            }
        }
        //n==i, w==j

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < w + 1; j++) {
                if(wt[i-1] > j){
                    dp[i][j] = dp[i-1][j];
                }else if(wt[i-1]<=j){
                    dp[i][j] = Math.max((val[i-1]+dp[i-1][j-wt[i-1]]), dp[i-1][j]);
                }
            }
        }
        return dp[n][w];
    }
}
