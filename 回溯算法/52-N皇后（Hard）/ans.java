class Solution {
    List<List<String>> ans = new LinkedList<List<String>>();
    boolean[] markedx;
    boolean[] markedy;
    boolean[] markedxy;
    boolean[] markedyx;
    int x = 0;
    public List<List<String>> solveNQueens(int n) {
        int[][] chess = new int[n][n];
        markedx = new boolean[n];
        markedy = new boolean[n];
        markedxy = new boolean[2*n -1];
        markedyx = new boolean[2*n -1];
        backtrack(chess, n, 0);
        int i = 0;
        return ans;
    }
    public void backtrack(int[][] chess, int n, int index){
        if(x == n){
            genstr(chess);
            return;
        }
        for(int i = index; i < n; i++){
            for(int j = 0; j < n; j++){
                if(!markedx[i]&&!markedy[j]&&!markedxy[i-j+n-1]&&!markedyx[i+j]){
                    chess[i][j] = 1;
                    markedx[i] = true;markedy[j] = true;markedxy[i-j+n-1] = true;markedyx[i+j] = true;
                    x++;
                    backtrack(chess, n, index+1);
                    x--;
                    chess[i][j] = 0;
                    markedx[i] = false;markedy[j] = false;markedxy[i-j+n-1] = false;markedyx[i+j] = false;
                }else if(j == n-1){
                    return;
                }
            }
        }
    }
    public void genstr(int[][] chess){
        List<String> list = new LinkedList<>();
        for(int i = 0; i < chess.length; i++){
            StringBuffer s = new StringBuffer();
            for(int j = 0; j < chess.length; j++){
                if(chess[i][j] == 0){
                    s.append('.');
                }else{
                    s.append('Q');
                }
            }
            list.add(s.toString());
        }
        ans.add(list);
    }
}