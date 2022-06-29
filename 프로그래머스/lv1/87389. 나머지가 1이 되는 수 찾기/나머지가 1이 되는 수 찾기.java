class Solution {
    public int solution(int n) {
        int ans = 1;
        while (true) {
            if (n % ans == 1) {
                return ans;
            }
            ans++;
        }
    }
}