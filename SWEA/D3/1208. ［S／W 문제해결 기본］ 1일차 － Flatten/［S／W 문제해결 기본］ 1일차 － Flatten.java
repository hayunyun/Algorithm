import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        for (int tc = 1; tc <= 10; tc++) {
            int dump = sc.nextInt();
            int[] boxes = new int[100];
            for (int i = 0; i < 100; i++) {
                boxes[i] = sc.nextInt();
            }
             
            while (dump-- > 0) {
                Arrays.sort(boxes);
                if (boxes[0] == boxes[99]) break;
                boxes[0]++; boxes[99]--;
            }
             
            Arrays.sort(boxes);
            System.out.printf("#%d %d\n", tc, boxes[99] - boxes[0]);        
        }
    }
 
}