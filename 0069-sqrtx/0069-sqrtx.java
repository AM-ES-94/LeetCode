class Solution {
    public int mySqrt(int x) {
        long s = 0;
        long e = x;
        long m=0;

        while (s <= e) {
            m = s + (e - s) / 2;
            if (m * m == x) return ((int) m);
            if (m * m > x) e = m - 1;
            else s = m + 1;
        }

        return ((int) e);
    }
}