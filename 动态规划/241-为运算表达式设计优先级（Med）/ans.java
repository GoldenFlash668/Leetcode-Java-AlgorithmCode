class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        int num = 0;
        for(char c:input.toCharArray()){
            if(isop(c)){
                numList.add(num);
                num = 0;
                opList.add(c);
                continue;
            }
            num = num*10+(c-'0');
        }
        numList.add(num);
        int N = numList.size();
        //ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList<Integer>[N][N];
        ArrayList<Integer>[][] dp = (ArrayList<Integer>[][]) new ArrayList[N][N];
        for(int i = 0; i < N; i++){
            ArrayList<Integer> result = new ArrayList<>();
            result.add(numList.get(i));
            dp[i][i] = result;
        }
        for(int n=2; n <= N; n++){
            for(int i = 0; i < N; i++){
                int j = i + n - 1;
                if(j >= N) break;
                ArrayList<Integer> result = new ArrayList<>();
                for(int s = i; s < j; s++){
                    ArrayList<Integer> result1 = dp[i][s];
                    ArrayList<Integer> result2 = dp[s + 1][j];
                    for(int x = 0; x < result1.size(); x++){
                        for(int y = 0; y < result2.size(); y++){
                            result.add(caculate(result1.get(x), result2.get(y), opList.get(s)));
                        }
                    }
                }
                dp[i][j] = result;
            }
        }
        return dp[0][N-1];
    }
    public int caculate(int a, int b, char c){
        if(c == '+'){
            return a+b;
        }
        else if(c == '-'){
            return a-b;
        }else{
            return a*b;
        }
    }
    public boolean isop(char c){
        return c=='+'||c=='-'||c=='*';
    }
}