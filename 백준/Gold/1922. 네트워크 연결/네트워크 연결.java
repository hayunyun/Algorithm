import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] group;
    
    /**
    최소신장트리로 풀이가 가능하다.
    (크루스칼 알고리즘 or 프림 알고리즘)
    본 코드는 크루스칼 알고리즘으로 풀이함
    (간선정렬 + 서로소집합) */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        
        N = Integer.parseInt(br.readLine()); // 정점
        M = Integer.parseInt(br.readLine()); // 간선

        info[] List = new info [M + 1]; // 간선리스트
        group = new int [N + 1]; // 서로소집합에 사용할 배열
        int ans = 0;

        StringTokenizer st;
        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); 
            int b = Integer.parseInt(st.nextToken()); 
            int c = Integer.parseInt(st.nextToken()); 
            List[i] = new info(a, b, c); // 간선리스트 채우기
        }

        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            group[i] = i;
        }

        Arrays.sort(List, 1, M+1); // 간선을 비용순 정렬

        // 간선을 N-1개 연결하면 최소신장트리 완성
        int connectCount = 0;
        for (int i = 1; i <= M; i++) {
            // 현재 선택된 간선의 두개 정점이 연결된 상태가 아니라면 연결해준다.
            if (find(List[i].node1) != find(List[i].node2)) {
                union(List[i].node1, List[i].node2);
                ans += List[i].distance;
                connectCount++;
            }

            if (connectCount == N - 1)
                break;
        }
        bw.write(String.valueOf(ans));
        bw.flush();
        bw.close();
    }

    static void union(int a, int b) {
        int aGroup = find(a);
        int bGroup = find(b);

        group[aGroup] = bGroup;
    }

    static int find(int x) {
        if (group[x] == x) return x;
        else
            return group[x] = find(group[x]);
    }
}

class info implements Comparable<info> {
    int node1;
    int node2;
    int distance;

    public info(int f, int t, int d) {
        this.node1 = f;
        this.node2 = t;
        this.distance = d;
    }

    @Override
    public int compareTo(info o) {
        return Integer.compare(distance, o.distance);
    }

}