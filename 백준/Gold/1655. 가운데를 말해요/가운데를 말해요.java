import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    static int n;
    static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            middle(num);
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }

    static void middle(int num) {
        /*
        우리는 무조건 최대힙의 top을 중간값으로 둘 것이다.
        두 힙의 크기가 같으면 최대힙에 값을 넣는다.
        크기가 다르면 최소힙에 넣는다.
        
        최대힙의 최댓값보다 최소힙의 최솟값이 크다면 둘을 바꾼다.
         */
        if (minHeap.size() == maxHeap.size()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        }
    }
}
