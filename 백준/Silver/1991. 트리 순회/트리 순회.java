import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static class Node {
        char self;
        Node left, right;

        public Node(char self){
            this.self = self;
        }

        public String toString(){
            return self + "";
        }
    }

    static Node[] tree;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        tree = new Node[n];
        char c = 'A';
        for (int i = 0; i < n; i++) {
            tree[i] = new Node(c++);
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char node = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            tree[node - 'A'].left = (left == '.') ? null : tree[left - 'A'];
            tree[node - 'A'].right = (right == '.') ? null : tree[right - 'A'];
        }

        front(tree[0]);
        sb.append("\n");

        mid(tree[0]);
        sb.append("\n");

        back(tree[0]);

        System.out.println(sb);
    }

    // 전위순회 : 루 - 왼 - 오
    static void front(Node nd) {
        sb.append(nd.self);
        if (nd.left != null) front(nd.left);
        if (nd.right != null) front(nd.right);
    }

    // 중위순회 : 왼 - 루 - 오
    static void mid(Node nd) {
        if (nd.left != null) mid(nd.left);
        sb.append(nd.self);
        if (nd.right != null) mid(nd.right);
    }

    // 후위순회 : 왼 - 우 - 루
    static void back(Node nd) {
        if (nd.left != null) back(nd.left);
        if (nd.right != null) back(nd.right);
        sb.append(nd.self);
    }
}