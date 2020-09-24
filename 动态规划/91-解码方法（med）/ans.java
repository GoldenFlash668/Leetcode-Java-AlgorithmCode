class Solution {
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) == '0'){
            return 0;
        }
        int[] dp = new int[s.length()];
        dp[0] = 1;
        char pre = s.charAt(0);
        for(int i = 1; i < s.length(); i++){
            if(s.charAt(i) != '0'){
                dp[i] = dp[i-1];
            }
            if((pre == '2' && (s.charAt(i) - '0') < 7) || pre == '1'){
                if(i - 2 > 0){
                    dp[i] += dp[i-2];
                }else{
                    dp[i] += 1;
                }
            }
            pre = s.charAt(i);
        }
        return dp[s.length()-1];
    }
}