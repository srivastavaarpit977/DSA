public class 3Strings {
    static int[][][] dp = new int[101][101][101];
    public int solve(String a, String b, String c) {
        int la = a.length(), lb = b.length(), lc = c.length();
        char[] A = a.toCharArray();
        char[] B = b.toCharArray();
        char[] C = c.toCharArray();
        for (int i = 0; i <= la; i++) {
            for (int j = 0; j <= lb; j++) {
                for (int k = 0; k <= lc; k++) {
                    // if any string is empty, length of longest common subsequence is 0. 
                    if (i == 0 || j == 0 || k == 0) {
                        dp[i][j][k] = 0;
                    } else {
                        // if each string has same character
                        if (A[i - 1] == B[j - 1] && A[i - 1] == C[k - 1]) {
                            dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                        } else {
                            //if characters don't match, take the maximum of previous calculated results.
                            dp[i][j][k] = Math.max(dp[i - 1][j][k], Math.max(dp[i][j - 1][k], dp[i][j][k - 1]));
                        }
                    }
                }
            }
        }
        return dp[la][lb][lc];
    }
}