package DynamicProgramming.P1_zero_One_knapsack;

public class Q1_Subset_Sum_Problem {
    public static void main(String[] args) {
        int[] arr = {2,3,5,8};
        int sum = 11;
        System.out.println(subsetSumWithRecursion(arr,arr.length,sum));
        System.out.println(subsetSumWithMemoization(arr,arr.length,sum));
        System.out.println(subsetSumWithTopDownDp(arr,arr.length,sum));

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

    private static boolean subsetSumWithTopDownDp(int[] arr, int n, int sum) {

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
        return dp[n][sum];
    }

}
