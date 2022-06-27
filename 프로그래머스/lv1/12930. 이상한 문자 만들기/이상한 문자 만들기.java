class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        for (int j = 0; j < s.length(); j++) {
            if (s.charAt(j) == ' ') {
                answer += ' ';
                idx = 0;
                continue;
            }
            
            if (idx % 2 == 0) {
                answer += Character.toUpperCase(s.charAt(j));
            }
            else {
                answer += Character.toLowerCase(s.charAt(j));
            }
            idx++;
        }
        
        return answer;
    }
}