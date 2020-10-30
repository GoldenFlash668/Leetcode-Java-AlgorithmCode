//下次遇到这个题时想一想另外一种方法

class Solution {
    public int longestSubstring(String s, int k) {
        int max = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c :s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        StringBuilder sb = new StringBuilder(s);
        for(int i = 0; i < s.length(); i++){
            if(map.get(s.charAt(i)) < k){
                sb.setCharAt(i, ',');
            }
        }
        s = sb.toString();
        String[] str = s.split(",");
        if(str.length == 1) {
            return str[0].length();
        }
        for(int i = 0; i < str.length; i++){
            max = Math.max(max, longestSubstring(str[i], k));
        }
        return max;
    }
}