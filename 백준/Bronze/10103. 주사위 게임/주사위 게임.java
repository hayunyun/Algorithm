import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int numberOfGames = Integer.parseInt(br.readLine());

        final int TOTAL_POINT = 100;
        int cyTotalPoint = TOTAL_POINT;
        int sdTotalPoint = TOTAL_POINT;

        for (int i = 0; i < numberOfGames; i++) {
            // 매 라운드마다, 각 사람은 주사위를 던진다
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cyPoint = Integer.parseInt(st.nextToken());
            int sdPoint = Integer.parseInt(st.nextToken());

            // 낮은 숫자가 나온 사람은 상대편 주사위에 나온 숫자만큼 점수를 잃게 된다
            // 두 사람의 주사위가 같은 숫자가 나온 경우에는 아무도 점수를 잃지 않는다.
            if (cyPoint > sdPoint) {
                sdTotalPoint -= cyPoint;
            } else if (cyPoint < sdPoint) {
                cyTotalPoint -= sdPoint;
            }

        }
        // 게임이 끝난 이후에 창영이의 점수, 둘째 줄에는 상덕이의 점수를 출력한다.
        System.out.println(cyTotalPoint);
        System.out.println(sdTotalPoint);
    }
}