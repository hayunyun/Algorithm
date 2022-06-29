class Solution {
    public long solution(int price, int money, int count) {
        long sum = 0;
        int origin = price;
        for (int i = 1; i <= count; i++) {
            sum += price;
            price += origin;
        }
        
        System.out.println(sum);
        
        if (sum < money) {
            return 0;
        }
        else {
            return sum - money;
        }
    }
}