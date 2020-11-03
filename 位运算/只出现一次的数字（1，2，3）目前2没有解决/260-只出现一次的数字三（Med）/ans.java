class Solution {
    public int[] singleNumber(int[] nums) {
        int bitmark = 0;
        for(int num : nums){
            bitmark ^= num;
        }
        int lastmark = bitmark & -bitmark;
        int x = 0;
        for(int num:nums){
            if((num & lastmark) != 0){
                x ^= num;
            }
        }
        return new int[]{x, x^bitmark};
    }
}