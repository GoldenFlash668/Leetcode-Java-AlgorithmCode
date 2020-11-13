class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        for(int i = 0; count < nums.length; i++){
            int curr = i;
            int pre = nums[curr];
            do{
                int next = (curr+k)%nums.length;
                int temp = nums[next];
                nums[next] = pre;
                pre = temp;
                curr = next;
                count++;
            }while(curr != i);
        }
    }
}