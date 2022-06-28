class Solution {
    public int solution(int n) {
        boolean[] check = new boolean[n + 1]; // false가 소수
        check[0] = true;
        check[1] = true;
        
        for (int i = 2; i <= Math.sqrt(n); i++) {
            for (int j = i * 2; j <= n; j += i) {
                if (check[j]) continue;
                check[j] = true;
            }
        }
        
        int answer = 0;
        for (int i = 2; i <= n; i++) {
            if (!check[i]) answer++;
        }
        
        return answer;
    }
}