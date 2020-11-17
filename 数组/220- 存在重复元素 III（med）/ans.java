class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            Integer s = set.ceiling(nums[i]);
            if(s != null && nums[i] >= (long)s - t) return true;
            Integer u = set.floor(nums[i]);
            if(u != null && nums[i] <= (long)u + t) return true;
            set.add(nums[i]);
            if(set.size() > k){
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}