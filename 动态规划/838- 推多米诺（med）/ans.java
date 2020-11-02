class Solution {
    public String pushDominoes(String dominoes) {
        int N = dominoes.length();
        StringBuffer res = new StringBuffer();
        int[] forces = new int[N];
        int force = 0;
        for(int i = 0; i < N; i++){
            if(dominoes.charAt(i) == 'R'){
                force = N;
            }else if(dominoes.charAt(i) == 'L'){
                force = 0;
            }else{
                force = Math.max(force-1, 0);
            }
            forces[i] = force;
        }
        for(int i = N-1; i >= 0; i--){
            if(dominoes.charAt(i) == 'R'){
                force = 0;
            }else if(dominoes.charAt(i) == 'L'){
                force = -N;
            }else{
                force = Math.min(force+1, 0);
            }
            forces[i] += force;
        }
        for(int i = 0; i < N; i++){
            if(forces[i] > 0) res.append("R");
            else if(forces[i] < 0) res.append("L");
            else res.append(".");
        }
        return res.toString();

    }
}