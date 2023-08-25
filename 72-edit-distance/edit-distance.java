class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }

        return helper(n-1, m-1, word1, word2, dp);
    }

    public int helper(int i, int j, String s, String t, int[][] dp){
        if(i<0 && j<0) return 0;

        if(i<0) return j+1;
        if(j<0) return i+1;

        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        //int match=0;
        if(s.charAt(i)==t.charAt(j)){
            dp[i][j]=helper(i-1, j-1, s, t, dp);
            return dp[i][j];
        }

        int not_match = 1+Math.min(helper(i-1, j-1, s, t, dp), Math.min(helper(i-1, j, s, t, dp), helper(i, j-1, s, t, dp)));

        dp[i][j] = not_match;

        return dp[i][j];
        
    }
}