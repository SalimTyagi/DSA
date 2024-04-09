package DynamicProgramming.P1_zero_One_knapsack;

import java.util.Arrays;

public class Q2_Equal_sum_partition {
    public static void main(String[] args) {
        int[] arr = {1,5,11,5};
        int n = arr.length;

        System.out.println(equalSumPartition_withRecursion(arr,n));
        System.out.println(equalSumPartition_withMemoization(arr,n));
        System.out.println(equalSumPartition_withTopDown(arr,n));
    }

    private static boolean equalSumPartition_withRecursion(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }

        if (sum%2!=0){
            return false;
        }

        return subsetSumWithRecursion(arr,n,sum/2);
    }

    private static boolean subsetSumWithRecursion(int[] arr, int n, int sum) {
        if(sum==0) return true;

        if(sum>0 && n==0) return false;

        if(arr[n-1]>sum){
            return subsetSumWithRecursion(arr,n-1,sum);
        }

        return subsetSumWithRecursion(arr,n-1,sum-arr[n-1])
                || subsetSumWithRecursion(arr,n-1,sum);

    }

    private static int equalSumPartition_withMemoization(int[] arr, int n) {
        int sum = 0;
        for (int item : arr){
            sum+=item;
        }

        if(sum%2!=0) return 0;

        return subsetSumWithMemoization(arr,n,sum/2);

    }

    private static int subsetSumWithMemoization(int[] arr, int n, int sum) {
        int[][] dp = new int[n+1][sum+1];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                dp[i][j] = -1;
            }
        }

        if(sum==0) return 1;
        if(n<=0) return 0;

        if (dp[n][sum] != -1) return dp[n][sum];

        if(arr[n-1]>sum){
            return dp[n][sum] = subsetSumWithMemoization(arr,n-1,sum);
        }
        else {
            if (subsetSumWithMemoization(arr, n - 1, sum) != 0
                    || subsetSumWithMemoization(arr, n - 1, sum - arr[n - 1])
                    != 0) {
                return dp[n - 1][sum] = 1;
            }
            else
                return dp[n - 1][sum] = 0;
        }
    }

    private static boolean equalSumPartition_withTopDown(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=arr[i];
        }

        if (sum%2!=0){
            return false;
        }

        boolean[][] dp = new boolean[n+1][sum+1];
        // initialization
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if(i==0) dp[i][j]=false;
                if(j==0) dp[i][j]= true;
            }
        }
        // n==i , sum==j==w
        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < sum+1; j++) {
                if (arr[i - 1] > j)
                    dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j)
                    dp[i][j] = dp[i - 1][j] ||
                            dp[i - 1][j - arr[i - 1]];
            }
        }
        return dp[n][sum/2];
    }
}
