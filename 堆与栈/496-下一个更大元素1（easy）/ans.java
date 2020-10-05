class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();
        int[] ans = new int[nums1.length];
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums2.length; i++){
            while(!stack.isEmpty()){
                int x = stack.peek();
                if(nums2[i] < x) break;
                else{
                    map.put(x, nums2[i]);
                }
                stack.pop();
            }
            stack.push(nums2[i]);
        }
        while(!stack.isEmpty()){
            map.put(stack.pop(), -1);
        }
        for(int i = 0; i < nums1.length; i++){
            ans[i] = map.get(nums1[i]);
        }
        return ans;
    }
}