package DynamicProgramming.P1_zero_One_knapsack;

public class Q3_Count_subset {
    public static void main(String[] args) {
        int[] arr = {2,3,5,6,8,10};
        int sum =10;

        System.out.println(countSubsetWithRecursion(arr,arr.length,sum));
        System.out.println(countSubsetWithTopDownDp(arr,arr.length,sum));
    }

    private static int countSubsetWithRecursion(int[] arr, int n,int sum) {
        if(n==0 || sum == 0 ){
            return 0;
        }
        return 0;

    }

    private static int countSubsetWithTopDownDp(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        //initialization
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i==0) dp[i][j] = 0;
                if(j==0) dp[i][j] = 1;
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {
                if(arr[i-1]>j){
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
                }
            }
        }

        return dp[n][sum];
    }
}
