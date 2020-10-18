class Solution {
    private class LargerNumberComparator implements Comparable<String>{
        @Override
        public int compareTo(String s1, String s2) {
            // TODO Auto-generated method stub
            String str1 = s1 + s2;
            String str2 = s2 + s1;
            return str1.compareTo(str2);
        }
    }
    public String largestNumber(int[] nums) {
        String[] num = new String[nums.length];
        int index = 0;
        for(int n : nums){
            num[index++] = String.valueOf(n);
        }
        Arrays.sort(num, new LargerNumberComparator());
        
        
    }
}