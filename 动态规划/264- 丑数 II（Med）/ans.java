//方法一：利用优先队列构造小顶堆
class Solution {
    public int nthUglyNumber(int n) {
        int[] nums = new int[1690];
        Set<Long> set = new HashSet<Long>();
        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        int[] arr = new int[]{2,3,5};
        set.add(1L);
        queue.add(1L);
        
        for(int i = 0; i < 1690; i++){
            long curr = queue.poll();
            nums[i] = (int)curr;
            for(int num:arr){
                long now = curr*num;
                if(!set.contains(now)){
                    queue.offer(now);
                    set.add(now);
                }
            }
        }
        return nums[n-1];
    }
}
//方法二：动态规划
class Solution {
    public int nthUglyNumber(int n) {
        int[] ans = new int[n];
        List<Integer> list = new LinkedList<Integer>();
        ans[0] = 1;
        int l2 =0, l3 = 0, l5 = 0;
        for(int i = 1; i < n; ){
            int curr = Math.min(ans[l5]*5, Math.min(ans[l2]*2, ans[l3]*3));
            if(!list.contains(curr)){
                list.add(curr);
                ans[i] = curr;
                i++;
            }
            if(curr == ans[l2]*2){
                l2++;
            }else if(curr == ans[l3]*3){
                l3++;
            }else{
                l5++;
            }
        }
        return ans[n-1];
    }
}