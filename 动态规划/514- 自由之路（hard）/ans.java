class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length(), m = key.length();
        Map<Character, ArrayList<Integer>> map = new HashMap<>();
        int index = 0;
        for(char c: ring.toCharArray()){
            ArrayList<Integer> list = map.getOrDefault(c, new ArrayList<Integer>());
            list.add(index++);
            map.put(c, list);
        }
        int ans = key.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for(int i : map.get(key.charAt(0))){
            dp[0][i] = Math.min(i, n-i) + 1;
        }
        for(int i = 1; i < m; i++){
            for(int j :map.get(key.charAt(i))){
                for(int k :map.get(key.charAt(i-1))){
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][k] + Math.min(Math.abs(j-k), n - Math.abs(j-k))+1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }
}