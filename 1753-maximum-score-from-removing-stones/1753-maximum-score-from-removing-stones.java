class Solution {
    public int maximumScore(int a, int b, int c) {
        int x = (a + b + c)/2;
        int y = a + b + c - Math.max(Math.max(a, b), c);
        return Math.min(x, y);
    }
}