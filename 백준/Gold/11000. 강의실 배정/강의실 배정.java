import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] nums = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            nums[i][0] = Integer.parseInt(st.nextToken()); // 시작
            nums[i][1] = Integer.parseInt(st.nextToken()); // 종료
        }

        // 시작시간 순 오름차순 정렬
        Arrays.sort(nums, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        // 우선순위 큐를 이용해서, 강의가 빨리 끝나는 순으로 기록할 수 있다
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(nums[0][1]);
        for (int i = 1 ; i < n; i++) {
            // 다음강의 시작시간이 현재 기록된 종료시간보다 크거나 같다면
            if (nums[i][0] >= pq.peek()) {
                pq.poll(); // 종료시간 갱신을 위해 뺀다
            }
            pq.add(nums[i][1]); // 새롭게 강의실 추가
        }

        // 결국 우선순위의 큐의 개수가 사용하는 강의실의 수
        System.out.println(pq.size());
    }
}
