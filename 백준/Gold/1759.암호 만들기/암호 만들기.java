import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;

public class Main {
    static int L, C;
    static char[] data;
    static ArrayList<String> result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st = new StringTokenizer(br.readLine());
        // StringBuilder sb = new StringBuilder();

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        data = new char[C];
        result = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<C; i++) {
            data[i] = st.nextToken().charAt(0);
        }
        
        Arrays.sort(data);
        dfs(0, 0, 0, -1, "");
        for (String obj : result) {
            bw.write(obj+"\n");
        }
        bw.flush();
    }

    public static void dfs(int length, int ja, int mo, int current, String pwd) {
        // 1. 체크인 - 생략 가능
        // 2. 목적지인가? - 길이, 모음 개수
        if (length == L) { // 목적지에 도착
            // 답인지 아닌지 확인
            if (ja >= 2 && mo >= 1) // 자음모음 조건 만족하는지
                result.add(pwd);
        }
        else {
            // 3. 연결된 곳을 순회 - 나보다 높은 알파벳
            for (int nextIndex = current + 1; nextIndex < data.length; nextIndex++) {
                //   4. 갈 수 있는가? - 생략 가능 (오름차순 정렬했기 때문)
                char nextData = data[nextIndex];
                if (nextData=='a' || nextData=='e' || nextData=='i' || nextData=='o'|| nextData=='u') { // 모음
                    //      5. 간다 - dfs(next) -> 모음
                    dfs(length+1, ja, mo+1, nextIndex, pwd+nextData);
                } else { // 자음
                    //      5. 간다 - dfs(next) -> 자음
                    dfs(length+1, ja+1, mo, nextIndex, pwd+nextData);
                }
            }
        }
        // 6. 체크아웃 - 생략 가능
    }
}
