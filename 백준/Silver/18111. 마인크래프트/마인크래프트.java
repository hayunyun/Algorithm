import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열
        int b = Integer.parseInt(st.nextToken()); // 인벤토리
        
        int[][] map = new int[n][m];
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        // 지도 채우기
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                min = Integer.min(min, map[i][j]);
                max = Integer.max(max, map[i][j]);
            }
        }

        // 최소 ~ 최대 블록까지 걸리는 시간 비교해서 가장 작은 시간 도출
        // 블록 제거 == 2초 & 블록 쌓기 == 1초
        // 인벤토리에 든 값을 확인해줘야함
        int time = Integer.MAX_VALUE;
        int floor = 0;
        for (int i = min; i <= max; i++) {
            int total = 0;
            int inventory = b;
            for (int j = 0; j < n; j++) {
                for (int z = 0; z < m; z++) {
                    // 기준값보다 현재값이 작으면 -> 블록 쌓기
                    if (map[j][z] < i) {
                        total += i - map[j][z];
                        inventory -= i - map[j][z];
                    }
                    // 기준값보다 현재값이 크면 -> 블록 제거
                    else if (map[j][z] > i) { 
                        total += (map[j][z] - i) * 2;
                        inventory += map[j][z] - i;
                    }
                }
            }

            // 인벤토리가 음수가 되지 않고(불가능), 걸린 시간이 기록된 시간보다 적으면 최솟값 교체
            if (inventory >= 0 && total <= time) {
                time = total;
                floor = i;
            }
        }

        System.out.println(time + " " + floor);
    }
}