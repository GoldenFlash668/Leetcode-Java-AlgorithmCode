//自己的解法
class Solution {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = 0-prices[0];
        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], prices[i]+dp[i-1][1]);
            dp[i][1] = Math.max(dp[i-1][0] - prices[i], dp[i-1][1]);
        }
        return dp[prices.length-1][0];
    }
}
//学习的答案的解法
class Solution {
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1])
                maxprofit += prices[i] - prices[i - 1];
        }
        return maxprofit;
    }
}
