class Solution {
    public boolean solution(int x) {
        int s = x;
        int n = 0;
        while (s > 0) {
            n += s % 10;
            s /= 10;
        }
        
        if (x % n == 0)
            return true;
        else return false;
    }
}