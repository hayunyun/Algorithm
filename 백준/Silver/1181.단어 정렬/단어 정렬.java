import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.Arrays;
import java.util.Comparator;
// import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for (int i=0; i<arr.length; i++) { //입력
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 단어 길이가 같을 경우
                if (s1.length() == s2.length()) {
                    return s1.compareTo(s2); // 사전순 정렬
                }
                // 그외
                else {
                    return s1.length() - s2.length(); // 양수면 변경, 아니면 변경X
                }
            }
        });

        bw.write(arr[0]+'\n');
        for (int i=1; i<N; i++) {
            // 중복아닌 단어만 출력
            if (!arr[i].equals(arr[i-1])) {
                bw.write(arr[i]+'\n');
            }
        }
        bw.flush();
    }
}