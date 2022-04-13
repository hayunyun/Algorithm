import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeSet<Integer> set = new TreeSet<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        while (n-- > 0) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        Iterator<Integer> iter = set.iterator(); // set을 Iterator 안에 담기
        while(iter.hasNext()) { // iterator에 다음 값이 있다면
            sb.append(iter.next() + " "); // iter에서 값 꺼내기
        }

        System.out.println(sb);
    }
}