class Solution {
    public int compareVersion(String version1, String version2) {
        String[] str1 = version1.split("\\.");
        String[] str2 = version2.split("\\.");
        int l1 = str1.length;
        int l2 = str2.length;
        int l = Math.max(l1,l2);
        for(int i = 0; i < l; i++){
            int num1 = 0;
            if(i < l1){
                for(char c : str1[i].toCharArray()){
                    int m = c-'0';
                    num1 = num1 * 10 + m;
                }
            }
            int num2 = 0;
            if(i < l2){
                for(char c : str2[i].toCharArray()){
                    int m = c-'0';
                    num2 = num2 * 10 + m;
                }
            }
            if(num1 > num2) return 1;
            else if(num1 < num2) return -1;
        }
        return 0;
    }
}