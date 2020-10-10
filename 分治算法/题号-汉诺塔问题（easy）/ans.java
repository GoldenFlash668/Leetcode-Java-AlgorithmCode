class Solution {
    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        int n = A.size();
        move(n, A, B, C);
    }
    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C){
        if(n == 1){
            int i = A.remove(A.size()-1);
            C.add(i);
            return;
        }
        move(n-1, A, C, B);
        C.add(A.remove(A.size()-1));
        move(n-1, B, A, C);
    }
}