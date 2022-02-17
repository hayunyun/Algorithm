import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static class Point implements Comparable<Point> {
        int x, y;

        public Point (int _x, int _y) {
            this.x = _x;
            this.y = _y;
        }

        @Override
        public int compareTo(Main.Point o) {
            if (this.x == o.x)
                return this.y - o.y;
            return this.x - o.x;
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        Point[] points = new Point[N];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            points[i] = new Point(x, y);
        }
        Arrays.sort(points);

        for (Point point : points)
            bw.write(point + "\n");

        bw.flush();
        bw.close();
    }

    // static Comparator<Point> comp = new Comparator<Point> () {
    //     @Override
    //     public int compare(Point o1, Point o2) {
    //         return o1.x - o2.y;
    //     }
    // };
}
