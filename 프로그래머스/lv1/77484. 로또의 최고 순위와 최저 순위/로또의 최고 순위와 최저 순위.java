import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        Arrays.sort(lottos);
        Arrays.sort(win_nums);
        int zero = 0;
        int cnt = 0;
        int idx = 0;
        
        // HashMap<Integer, Integer> rank = new HashMap<>();
        // int right = 6;
        // for (int i = 1; i <= 6; i++) {
        //     rank.put(right--, i);
        // }
        // rank.put(0, 6);
        
        while (idx < lottos.length && lottos[idx] == 0) {
            zero++;
            idx++;
        }
        for (int num : win_nums) {
            if (idx >= lottos.length) break;
            if (lottos[idx] < num) idx++;
            if (idx < lottos.length) {
                if (num == lottos[idx]) {
                    cnt++;
                    idx++;
                    System.out.println(num);
                }
            }
        } 
        
        answer[0] = 7 - (cnt+zero == 0 ? 1 : cnt+zero);
        answer[1] = 7 - (cnt <= 1 ? 1 : cnt);
        System.out.println(cnt + " " + zero);
        
        return answer;
    }
}