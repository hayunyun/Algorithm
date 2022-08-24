import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static ArrayList<Integer> [] map; // 인접리스트 방식
    static int[] indegree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new ArrayList [N+1];
        indegree = new int[N+1];

        // 그래프 초기화
        for (int i = 1; i < N+1; i++) {
            map[i] = new ArrayList<>();
        }

        // 진입차수가 0이 되어 탐색순서가 도달한 정점을 담는 큐
        ArrayDeque<Integer> q = new ArrayDeque<>();

        // 그래프 정의
        // 먼저 출력되어야 하는 학생 -> 나중에 출력되어야 하는 학생 순서로 그래프 구상
        // 나중에 출력되어야 하는 학생들의 경우엔 진입차수 1 증가
        int from, to;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken()); 
            map[from].add(to); // 인접 정점들 넣기
            indegree[to] += 1; // 인접 정점에 진입차수+1
        }

        // 위상정렬
        // 최초 탐색을 할 학생을 찾는다.
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0)
                q.addLast(i); // 진입차수가 0일 경우 큐에 추가
        }

        int seq = 0; // 마지막 공백을 출력하지 않기 위한 변수

        // q가 빌때까지 수행
        while (!q.isEmpty()) {
            int now = q.pollLast(); // 현재 탐색 위치
            seq++;
            if (seq == N) {
                bw.write(String.valueOf(now)); // 맨 마지막 값 출력 시 그대로 출력
            }
            else {
                bw.write(now + " ");
            }

            // 인접한 노드들을 검사한다.
            for(int next : map[now]) {
                // 이 때 진입차수가 0보다 큰 정점들만 탐색한다 (0이면 이미 큐에 있음)
                if(indegree[next] > 0) {
                    // 진입차수를 하나씩 내려주고, 0이 되었다면 큐에 넣어준다.
                    indegree[next]--;
                    if (indegree[next] == 0)
                        q.addLast(next);
                }
            }
        }
        bw.flush();
        bw.close();
    }
}