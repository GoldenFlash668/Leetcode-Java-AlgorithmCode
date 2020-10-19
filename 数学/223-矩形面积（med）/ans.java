class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int ans = 0;
        ans += getArea(A, B, C, D);
        ans += getArea(E, F, G, H);
        if(A >= G ||C <= E|| D <= F || H <= B){
            return ans;
        }
        ans -= getArea(Math.max(A, E),  Math.max(B, F), Math.min(C, G),  Math.min(D, H));
        return ans;
    }
    int getArea(int A, int B, int C, int D){
        return (C-A)*(D-B);
    }
}