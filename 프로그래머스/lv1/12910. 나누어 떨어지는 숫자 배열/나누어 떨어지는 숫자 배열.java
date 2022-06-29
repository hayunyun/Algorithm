import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        for (int n : arr) {
            if (n % divisor == 0) {
                ans.add(n);
            }
        }
        Collections.sort(ans);
        
        if (ans.isEmpty()) {
            answer = new int[] {-1};
        }
        else {
            answer = ans.stream().mapToInt(i->i).toArray();
        }
        
        return answer;
    }
}