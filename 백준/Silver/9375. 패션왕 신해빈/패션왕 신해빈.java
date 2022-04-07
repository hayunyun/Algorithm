import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/input.txt"));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        while(n-- > 0) {
            int m = Integer.parseInt(br.readLine());
            String[][] closet = new String[m][2];
            for (int i = 0; i < m; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                closet[i][0] = st.nextToken();
                closet[i][1] = st.nextToken();
            }

            HashMap<String, Integer> category = new HashMap<>();
            for(String[] cloth : closet) {
                if (!category.containsKey(cloth[1])) {
                    category.put(cloth[1], 1);
                }
                else {
                    category.put(cloth[1], category.get(cloth[1]) + 1);
                }
            }

            int answer = 1;
            for (int count : category.values()) {
                answer *= (count + 1); // null의 경우까지 포함
            }

            // 옷 종류별 조합 - 1 (null만으로 이루어진 조합 빼기)
            sb.append(answer - 1).append("\n");
        }
        System.out.print(sb);
    }
}