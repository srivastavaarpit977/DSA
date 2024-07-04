public class matrixchainmultiplication {
    public int solve(int[] A) {
        int n = A.length;
        int[][] m = new int[n][n];
        int i, j, k, L, q;
        for (i = 1; i < n; i++)
            m[i][i] = 0;
        for (L = 2; L < n; L++) {
            for (i = 1; i < n - L + 1; i++) {
                j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;
                // try to divide at every i<=k<=j-1 
                for (k = i; k <= j - 1; k++) {
                    q = m[i][k] + m[k + 1][j] + A[i - 1] * A[k] * A[j];
                    if (q < m[i][j])
                        m[i][j] = q;
                }
            }
        }
        return m[1][n - 1];
    }
}