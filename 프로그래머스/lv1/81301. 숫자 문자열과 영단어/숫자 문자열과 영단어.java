import java.util.*;

class Solution {
    public int solution(String s) {
        HashMap<String, Integer> word = new HashMap<>();
        word.put("ze", 0);
        word.put("on", 1);
        word.put("tw", 2);
        word.put("th", 3);
        word.put("fo", 4);
        word.put("fi", 5);
        word.put("si", 6);
        word.put("se", 7);
        word.put("ei", 8);
        word.put("ni", 9);
        
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= '0' && s.charAt(i) <= '9') ans += String.valueOf(s.charAt(i));
            else {
                if (i < s.length() - 1) {
                    String what = String.valueOf(s.charAt(i)) + String.valueOf(s.charAt(i+1));
                    if (word.containsKey(what))
                        ans += String.valueOf(word.get(what));
                }
            }
        }
        int answer = Integer.parseInt(ans);
        return answer;
    }
}