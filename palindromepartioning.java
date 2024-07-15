public class palindromepartioning {
    private int isPalin[][];
    private int N;
    private ArrayList < ArrayList < String >> mRes;
    private String mString;
    public ArrayList < ArrayList < String >> partition(String A) {
        mRes = new ArrayList < > ();
        N = A.length();
        if (N == 0)
            return null;
        mString = A;
        isPalin = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(isPalin[i], -1);
        }
        ArrayList < String > str = new ArrayList < > ();
        rec(str, 0);
        return mRes;
    }
    public void rec(ArrayList < String > str, int index) {
        if (index == N) {
            // we reached the end of the string and valid sequence of strings found.
            mRes.add(new ArrayList(str));
            return;
        }
        for (int i = index; i < N; i++) {
            // check if the substring str[index..i] is a palindrome
            if (isPalindrome(index, i)) {
                str.add(mString.substring(index, i + 1));
                rec(str, i + 1);
                str.remove(str.size() - 1);
            }
        }
    }
    public boolean isPalindrome(int start, int end) {
        if (start < 0 || start >= N || end < 0 || end >= N)
            return false;
        if (isPalin[start][end] != -1)
            return isPalin[start][end] == 1;
        int i, j;
        for (i = start, j = end; i < j; i++, j--) {
            if (mString.charAt(i) != mString.charAt(j)) {
                isPalin[start][end] = 0;
                return false;
            }
        }
        isPalin[start][end] = 1;
        return true;
    }
}