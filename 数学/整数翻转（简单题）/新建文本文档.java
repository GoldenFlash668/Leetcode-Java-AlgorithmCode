class Solution {
    public int reverse(int x) {
        int y = 0 , m ;
        while(x!=0){
            m = x%10;
            x = x/10;
            if (y > Integer.MAX_VALUE/10 || (y == Integer.MAX_VALUE / 10 && m > 7)) return 0;
            if (y < Integer.MIN_VALUE/10 || (y == Integer.MIN_VALUE / 10 && m < -8)) return 0;
            y = y*10 + m ;
            
        }
        if(x>0){
            return y ;
        }
        else{
            return y ;
        }
    }
}
//要注意题目要求 32 位的有符号整数