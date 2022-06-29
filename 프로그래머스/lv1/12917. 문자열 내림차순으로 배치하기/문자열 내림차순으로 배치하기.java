import java.util.*;

class Solution {
    public String solution(String s) {
        String[] str = s.split("");
        Arrays.sort(str);
        
        String answer = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            answer += str[i];
        }
        
        return answer;
    }
}