/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 * @return a random integer in the range 1 to 7
 */
class Solution extends SolBase {
    public int rand10() {
        while(true){
            int x1 = (rand7()-1)*7 + rand7();
            if(x1 <= 40) return 1+x1%10;
            x1 = (x1-40-1)*7 + rand7();
            if(x1 <= 60) return 1+x1%10;
            x1 = (x1-60-1)*7 + rand7();
            if(x1 <= 20) return 1+x1%10;
        }
    }
}