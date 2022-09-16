class Solution {
    public int largestVariance(String s) {
        int res = 0;
        // dp[a][b][0] is the freq of a
        // dp[a][b][1] is the max(freqa - freqb) in all substring, minmum is -1
        int[][][] dp = new int[26][26][2];
        System.out.println(dp[0][0]);
        for (int i = 0; i < 26; i++)
            for (int j = 0; j < 26; j++)
                dp[i][j][1] = -10000;

        // System.out.println(dp[1][1][0]);
        // System.out.println(dp[1][1][1]);
        
        for (int idx = 0; idx < s.length(); idx++) {
            //ASC 11 value of the character
            int i = s.charAt(idx) - 'a';
            // System.out.println("char: " +s.charAt(idx));
            for (int j = 0; j < 26; j++) {
                //checks if it is on the right character
                if (i != j) {
                    // current ch freq + 1
                    //example: dp[a][b][0] += 1 for each occurance of the two
                    dp[i][j][0] += 1;
                    dp[i][j][1] += 1;

                    // update b&a situation
                    // System.out.println("dp before:" + dp[j][i][1]);
                    dp[j][i][1] = dp[j][i][0] - 1;
                    // System.out.println("dp after:" + dp[j][i][1]);
                    if (dp[j][i][0] > 0)
                        dp[j][i][0] -= 1;

                    res = Math.max(dp[j][i][1], res);
                    // System.out.println("res before:" + res);
                    res = Math.max(dp[i][j][1], res);
                    // System.out.println("res after:" + res);
                }
            }
        }

        return res;
    }
}
