import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static class Block {
        int num;
        boolean calc; // 한 블럭당 연산은 1회만 가능

        public Block(int num, boolean calc) {
            this.num = num;
            this.calc = calc;
        }
    }
    static int n, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        int[][] map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MIN_VALUE;

        game(0, map);
        System.out.println(ans);
    }

    static void game(int cnt, int[][] map) {
        findMax(map);

        if (cnt == 5) {
            return;
        }

        for (int j = 0; j < 4; j++) {
            int[][] newMap = copyMap(map);
            if (j == 0) {
                game(cnt + 1, left(newMap));
            } else if (j == 1) {
                game(cnt + 1, right(newMap));
            } else if (j == 2) {
                game(cnt + 1, up(newMap));
            } else {
                game(cnt + 1, down(newMap));
            }
        }
    }

    static void findMax(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, map[i][j]);
            }
        }
    }

    static int[][] left(int[][] map) {
        // 왼쪽 이동 (행 별로 체크)
        // 0열부터 오른쪽 수와 같고, 왼쪽 방향이 방문체크 되어있지 않으면 합쳐짐
        // 이전 수가 0이면 넘어감
        Stack<Block> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] != 0) {
                    // 스택이 비어있지 않고, 숫자가 같고, 연산이 가능하다면
                    if (!stack.isEmpty() && map[i][j] == stack.peek().num && stack.peek().calc) {
                        stack.pop(); // 빼고 2배해서 다시 넣는다
                        stack.push(new Block(map[i][j] * 2, false)); // 연산 한번 일어나면 더이상 X
                    } else {
                        stack.push(new Block(map[i][j], true)); // 바로 스택에 넣는다
                    }
                    map[i][j] = 0;
                }
            }

            if (!stack.isEmpty()) {
                int idx = stack.size() - 1;
                while(!stack.isEmpty()) {
                    map[i][idx--] = stack.pop().num;
                }
            }
        }

        return map;
    }

    static int[][] right(int[][] map) {
        // 오른쪽 이동 (행 별로 체크)
        // n-1열부터 왼쪽 수와 같고, 왼쪽 방향이 방문체크 되어있지 않으면 합쳐짐
        // 이전 수가 0이면 넘어감
        Stack<Block> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                if (map[i][j] != 0) {
                    // 스택이 비어있지 않고, 숫자가 같고, 연산이 가능하다면
                    if (!stack.isEmpty() && map[i][j] == stack.peek().num && stack.peek().calc) {
                        stack.pop(); // 빼고 2배해서 다시 넣는다
                        stack.push(new Block(map[i][j] * 2, false)); // 연산 한번 일어나면 더이상 X
                    } else {
                        stack.push(new Block(map[i][j], true));
                    }
                    map[i][j] = 0;
                }
            }

            if (!stack.isEmpty()) {
                int idx = n - stack.size();
                while (!stack.isEmpty()) {
                    map[i][idx++] = stack.pop().num;
                }
            }
        }

        return map;
    }

    static int[][] up(int[][] map) {
        Stack<Block> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (map[j][i] != 0) {
                    // 스택이 비어있지 않고, 숫자가 같고, 연산이 가능하다면
                    if (!stack.isEmpty() && map[j][i] == stack.peek().num && stack.peek().calc) {
                        stack.pop(); // 빼고 2배해서 다시 넣는다
                        stack.push(new Block(map[j][i] * 2, false)); // 연산 한번 일어나면 더이상 X
                    } else {
                        stack.push(new Block(map[j][i], true)); // 바로 스택에 넣는다
                    }
                    map[j][i] = 0;
                }
            }

            if (!stack.isEmpty()) {
                int idx = stack.size() - 1;
                while (!stack.isEmpty()) {
                    map[idx--][i] = stack.pop().num;
                }
            }
        }

        return map;
    }

    static int[][] down(int[][] map) {
        Stack<Block> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            for (int j = n-1; j >= 0; j--) {
                if (map[j][i] != 0) {
                    // 스택이 비어있지 않고, 숫자가 같고, 연산이 가능하다면
                    if (!stack.isEmpty() && map[j][i] == stack.peek().num && stack.peek().calc) {
                        stack.pop(); // 빼고 2배해서 다시 넣는다
                        stack.push(new Block(map[j][i] * 2, false)); // 연산 한번 일어나면 더이상 X
                    } else {
                        stack.push(new Block(map[j][i], true)); // 바로 스택에 넣는다
                    }
                    map[j][i] = 0;
                }
            }

            if (!stack.isEmpty()) {
                int idx = n - stack.size();
                while (!stack.isEmpty()) {
                    map[idx++][i] = stack.pop().num;
                }
            }
        }

        return map;
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                newMap[i][j] = map[i][j];
            }
        }

        return newMap;
    }
}
