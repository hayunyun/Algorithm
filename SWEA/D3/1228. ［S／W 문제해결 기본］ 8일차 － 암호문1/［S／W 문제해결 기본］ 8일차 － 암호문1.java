import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        
        for (int tc = 1; tc <= 10; tc++) {
            int n = sc.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(sc.nextInt());
            }
            
            int method = sc.nextInt();
            for (int i = 0; i < method; i++) {
                String I = sc.next();
                int idx = sc.nextInt();
                int num = sc.nextInt();

                for (int j = 0; j < num; j++) {
                    nums.add(idx++, sc.nextInt());
                }
            }

            System.out.printf("#%d ", tc);
            for (int i = 0; i < 10; i++) {
                System.out.print(nums.get(i) + " ");
            }
            System.out.println();
        }
    }
}
