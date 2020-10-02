方法一：
class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int num:nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }
        int n = (nums.length+1)/2;
        for(int key: map.keySet()){
            if(map.get(key) >= n){
                return key;
            }
        }
        return 0;

    }
}
方法二：
class Solution {
    public int majorityElement(int[] nums) {
        int count = 0;
        Integer cand = null;
        for(int num: nums){
            if(count == 0){
                count++;
                cand = num;
            }else{
                if(num == cand){
                    count++;
                }else{
                    count--;
                }
            }
        }
        return cand;
    }
}