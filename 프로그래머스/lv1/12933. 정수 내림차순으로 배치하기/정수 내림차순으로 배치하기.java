import java.util.*;

class Solution {
    public long solution(long n) {
        long answer = 0;
        int len = String.valueOf(n).length();
        int[] nums = new int[len];
        
        for (int i = 0; i < len; i++) {
            nums[i] = (int) (n % 10);
            n /= 10;
        }
        
        Arrays.sort(nums);
        
        for (int i = 0; i < len; i++) {
            answer += nums[i] * Math.pow(10, i);
        }
        
        return answer;
    }
}