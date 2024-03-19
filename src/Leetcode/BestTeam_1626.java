package Leetcode;

import java.util.Arrays;

public class BestTeam_1626 {
    public static void main(String[] args) {
        int[] ages = {2,1,2,1};
        int[] scores = {4,5,6,5};

        System.out.println(bestTeamScore(scores,ages));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
       int[][] team = new int[scores.length][2];

        for (int i = 0; i < scores.length; i++) {
            team[i][0] = ages[i];
            team[i][1] = scores[i];
        }

        Arrays.sort(team,(a,b)-> a[0]==b[0] ? a[1]-b[1] : a[0]-b[0]);
        int bestScore = 0;
        int[] dp = new int[scores.length];

        for (int i = 0; i < scores.length; i++) {
            dp[i] = team[i][1];
            bestScore = Math.max(bestScore,dp[i]);
        }

        for (int i = 0; i < scores.length; i++) {
            for (int j = 0; j < i; j++) {
                if(team[i][1] >= team[j][1]){
                    dp[i] = Math.max(dp[i],team[i][1]+dp[j]);
                }
            }
            bestScore = Math.max(bestScore,dp[i]);
        }
        return bestScore;
    }
}
