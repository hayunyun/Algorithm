import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    /*
     * 1. 문자열의 뒤에 A 추가
     * 2. 문자열을 뒤집고 뒤에 B 추가
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String goal = br.readLine();

        while (str.length() < goal.length()) {
            if (goal.charAt(goal.length() - 1) == 'A') {
                goal = goal.substring(0, goal.length()-1);
            } else  {
                StringBuilder sb = new StringBuilder(goal.substring(0, goal.length()-1));
                goal = sb.reverse().toString();
            }
        }

        if (str.equals(goal)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}