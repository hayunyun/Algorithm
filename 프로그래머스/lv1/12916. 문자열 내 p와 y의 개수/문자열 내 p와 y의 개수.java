class Solution {
    boolean solution(String s) {
        boolean answer = true;

        s = s.toLowerCase();
        int[] cnt = new int[2];
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'p') {
                cnt[0]++;
            }
            else if (s.charAt(i) == 'y') {
                cnt[1]++;
            }
        }
        
        if (cnt[0] == cnt[1])
            return true;
        else return false;
    }
}