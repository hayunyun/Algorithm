class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int [2];
        answer[0] = gcd(n, m);
        answer[1] = n * m / answer[0];
        return answer;
    }
    
    static int gcd(int a, int b) {
        while (true) {
            if (a % b == 0) {
                return b;
            }
            else {
                int tmp = b;
                b = a % b;
                a = tmp;
            }
        }
    }
}