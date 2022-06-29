import java.util.*;

public class Solution {
    public int[] solution(int [] arr) {
        int[] answer = {};
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(arr[0]);
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i-1]) continue;
            ans.add(arr[i]);
        }

        return ans.stream().mapToInt(i->i).toArray();
    }
}