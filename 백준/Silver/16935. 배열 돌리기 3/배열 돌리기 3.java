import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int n = Integer.parseInt(st.nextToken());
            spin(n);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void spin(int num) {
        int temp;
        int[][] newMap;

        switch(num) {
            // 1. 상하반전
            case 1:
                newMap = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        newMap[n-i-1][j] = map[i][j];
                    }
                }
                map = newMap;
                break;
            // 2. 좌우반전
            case 2:
                newMap = new int[n][m];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        newMap[i][m-j-1] = map[i][j];
                    }
                }
                map = newMap;
                break;
            // 3. 오른쪽으로 90도
            case 3:
                newMap = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        newMap[j][n-i-1] = map[i][j];
                    }
                }

                temp = n;
                n = m;
                m = temp;
                map = newMap;
                break;
            // 4. 왼쪽으로 90도
            case 4:
                newMap = new int[m][n];
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        newMap[m-j-1][i] = map[i][j];
                    }
                }

                temp = n;
                n = m;
                m = temp;
                map = newMap;
                break;
            // 5. 부분배열 시계방향
            case 5:
                newMap = new int[n][m];
                int halfN = n/2;
                int halfM = m/2;

                // 1->2
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newMap[i][j + halfM] = map[i][j];
                    }
                }

                // 2->3
                for (int i = 0; i < halfN; i++) {
                    for (int j = halfM; j < m; j++) {
                        newMap[i + halfN][j] = map[i][j];
                    }
                }

                // 3->4
                for (int i = halfN; i < n; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newMap[i][j] = map[i][j + halfM];
                    }
                }

                // 4->1
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newMap[i][j] = map[i + halfN][j];
                    }
                }

                map = newMap;
                break;
            // 6. 부분배열 반시계방향
            case 6:
                newMap = new int[n][m];
                halfN = n/2;
                halfM = m/2;

                // 1->4
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newMap[i + halfN][j] = map[i][j];
                    }
                }

                // 4->3
                for (int i = halfN; i < n; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newMap[i][j+halfM] = map[i][j];
                    }
                }

                // 3->2
                for (int i = 0; i < halfN; i++) {
                    for (int j = halfM; j < m; j++) {
                        newMap[i][j] = map[i + halfN][j];
                    }
                }

                // 2->1
                for (int i = 0; i < halfN; i++) {
                    for (int j = 0; j < halfM; j++) {
                        newMap[i][j] = map[i][j + halfM];
                    }
                }

                map = newMap;
                break;
        }
    }
}