import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, c;
    static int[] nums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nums);

        System.out.println(binarySearch());

    }

    // 설치가능한 최소거리보다 크거나 같다면 공유기 설치 가능
    // 거리를 탐색 범위로 잡고 이분탐색을 하며, 해당 거리에 설치 가능한 공유기의 개수에 따라 탐색하는 거리의 범위를 좁혀나가자
    // 최소거리가 작으면 -> 공유기 설치 개수가 늘어남
    // 최소거리가 크면 -> 공유기 설치 개수가 줄어들음
    // 최소거리의 '최댓값'을 구해야 하므로 upper bound 사용
    static int binarySearch() {
        int lo = 0;
        int hi = nums[n - 1];
        while (lo < hi) {
            int mid = (lo + hi) / 2;

            // 설치가능한 공유기 수보다 작다면, 최소거리가 엄청 큰 것 -> 최소거리를 줄여 공유기 설치를 늘린다
            if (isPossible(mid) < c) {
                hi = mid;
            } else {
            // 설치가능한 공유기 수보다 크거나 같으면, 최소거리를 늘려서 공유기 설치를 줄이며 최소거리가 가질 수 있는 최댓값을 찾는다
                lo = mid + 1;
            }
        }

        return hi - 1; // 탐색값보다 1칸 많기때문에 -1해서 사용
    }

    private static int isPossible(int dist) {
        // 첫번째 공유기는 무조건 설치
        int cnt = 1;
        int prevIdx = nums[0];

        for (int i = 1; i < n; i++) {
            int nowHome = nums[i];
            if (nowHome - prevIdx >= dist) {
                cnt++;
                prevIdx = nowHome;
            }
        }

        return cnt;
    }
}
