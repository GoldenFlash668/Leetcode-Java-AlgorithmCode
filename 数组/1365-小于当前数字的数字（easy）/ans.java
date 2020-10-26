class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int n = nums.length;
        int[][] copy =new int[n][2];
        for(int i=0; i < n; i++){
            copy[i][0] = nums[i];
            copy[i][1] = i;
        }
        Arrays.sort(copy, new Comparator<int[]>(){
            public int compare(int[] data1, int[] data2){
                return data1[0] - data2[0];
            }
        });
        int[] ans = new int[n];
        int prve = -1;
        for(int i = 0; i < n; i++){
            if(prve == -1 || copy[i][0] != copy[i-1][0]){
                prve = i;
            }
            ans[copy[i][1]] = prve;
        }
        return ans;
    }
}