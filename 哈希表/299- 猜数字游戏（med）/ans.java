class Solution {
    public String getHint(String secret, String guess) {
        int l = secret.length();
        int[] cache = new int[10];
        int xA = 0;
        int xB = 0;
        for(int i = 0; i < l; i++){
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if(s == g){
                xA++;
            }else{
                if(cache[s-'0']++ < 0) xB++;
                if(cache[g-'0']-- > 0) xB++;
            }
        }
        return xA + "A" + xB + "B";
    }
}
