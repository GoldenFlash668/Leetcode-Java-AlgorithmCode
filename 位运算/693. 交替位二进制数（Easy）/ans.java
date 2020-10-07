class Solution {
    public boolean hasAlternatingBits(int n) {
        int num = (n^(n>>1)) + 1;
        return (num&(num-1)) == 0;
    }
}