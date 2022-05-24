import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int c = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < c; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int n = Integer.parseInt(st.nextToken());

                if (str.equals("I")) {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else {
                    if (map.isEmpty()) continue;

                    int key = n == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(key, map.get(key) - 1) == 1) {
                        map.remove(key);
                    }

                }
            }

            if (map.isEmpty()) sb.append("EMPTY");
            else {
                sb.append(map.lastKey() + " " + map.firstKey());
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}