import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char [] nums = br.readLine().toCharArray();
        int[] numbers = new int[10];

        for (int i = 0; i < nums.length; i++) {
            int x = nums[i] - '0';
            if (x == 9) x = 6;
            numbers[x]++;
        }

        numbers[6] = numbers[6] % 2 == 0 ? numbers[6] / 2 : numbers[6] / 2 + 1;

        int max = 0;
        for (int i = 0; i < 10; i++) {
            max = Integer.max(max, numbers[i]);
        }
        System.out.println(max);
    }
}