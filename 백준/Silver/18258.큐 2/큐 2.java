import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        Queue Q = new Queue();
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String S = st.nextToken();
            if (S.equals("push")) {
                Q.push(Integer.parseInt(st.nextToken()));
            }
            else if (S.equals("pop")) bw.write(Q.pop() + "\n");
            else if (S.equals("size")) bw.write(Q.size() + "\n");
            else if (S.equals("empty")) bw.write(Q.empty() + "\n");
            else if (S.equals("front")) bw.write(Q.front() + "\n");
            else if (S.equals("back")) bw.write(Q.back() + "\n");
        }
        bw.flush();
    }
}

class Queue {
    LinkedList<Integer> Q = new LinkedList<>();
    public void push(int x) {
        Q.add(x);
    }

    public int pop() {
        if (Q.isEmpty()) return -1;
        else {
            return Q.poll();
        }
    }

    public int size() {
        return Q.size();
    }

    public int empty() {
        if (Q.isEmpty()) return 1;
        else return 0;
    }

    public int front() {
        if (Q.isEmpty()) return -1;
        else return Q.getFirst();
    }

    public int back() {
        if (Q.isEmpty()) return -1;
        else return Q.getLast();
    }
}