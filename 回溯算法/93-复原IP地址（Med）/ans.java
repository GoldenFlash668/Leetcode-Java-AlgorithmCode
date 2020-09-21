class Solution {
    List<String> res = new LinkedList<>();
    int[] ipnum = new int[4];
    public List<String> restoreIpAddresses(String s) {
        backtrack(s, 0, 0);
        return res;
    }
    public void backtrack(String s , int index, int begin){
        if(index == 4){
            if(begin == s.length()){
                StringBuffer ipAddr = new StringBuffer();
                for (int i = 0; i < 4; ++i) {
                    ipAddr.append(ipnum[i]);
                    if (i != 3) {
                        ipAddr.append('.');
                    }
                }
                res.add(ipAddr.toString());
            }
            return;
        }
        if(begin == s.length()){
            return;
        }
        if(s.charAt(begin) == '0'){
            ipnum[index] = 0;
            backtrack(s, index+1, begin+1);
        }
        int address = 0;
        for(int i = begin; i < s.length(); i++){
            address = address * 10 + (s.charAt(i) - '0');
            if(address <= 255 && address > 0){
                ipnum[index] = address;
                backtrack(s, index+1, i+1);
            }else {
                break;
            }
        }
    }
}