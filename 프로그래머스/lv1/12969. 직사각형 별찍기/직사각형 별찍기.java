import java.util.Scanner;

class Solution {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int i = 0; i < b; i++) {
            star(a);
            sb.append("\n");
        }
        System.out.println(sb);
    }
    
    static void star(int n) {
        for (int j = 0; j < n; j++) {
            sb.append("*");
        }
    }
}