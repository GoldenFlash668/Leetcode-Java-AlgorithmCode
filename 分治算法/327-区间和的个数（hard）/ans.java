class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length + 1];
        long s = 0;
        for(int i = 0; i < nums.length; i++){
            s += nums[i];
            sum[i+1] = s; 
        }
        return Merge(sum, lower, upper, 0, sum.length-1);
    }
    private int Merge(long[] sum, int lower, int upper, int left, int right){
        if(left == right){
            return 0;
        }
        int mid = left + (right-left)/2;
        int n1 = Merge(sum, lower, upper, left, mid);
        int n2 = Merge(sum, lower, upper, mid + 1, right);
        int ret = n1 + n2;
        int r1 = mid + 1;
        int r2 = mid + 1;
        for(int i = left; i <= mid; i++){
            while(r1 <= right && sum[r1] - sum[i] < lower){
                r1++;
            }
            while(r2 <= right && sum[r2] - sum[i] <= upper){
                r2++;
            }
            ret += r2 - r1;
        }
        int[] sorts = new int[right - left + 1];
        int index = 0;
        int p1 = left, p2 = mid + 1;
        while(p1 <= mid || p2 <= right){
            if(p1 > mid){
                sorts[index++] = (int)sum[p2++];
            }else if(p2 > right){
                sorts[index++] = (int)sum[p1++];
            }else{
                if(sum[p1] < sum[p2]){
                    sorts[index++] = (int)sum[p1++];
                }else{
                    sorts[index++] = (int)sum[p2++];
                }
            }
        }
        for(int i = 0; i < sorts.length; i++){
            sum[left++] = sorts[i];   
        }
        return ret;
    }
}