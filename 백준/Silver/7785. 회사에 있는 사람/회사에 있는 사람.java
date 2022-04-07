import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
//        System.setIn(new FileInputStream("src/input.txt"));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        HashMap<String, String> info = new HashMap<>();
        while(n-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            info.put(st.nextToken(), st.nextToken());
        }

        ArrayList<String> people = new ArrayList<>();
        for (String name : info.keySet()) {
            if (info.get(name).equals("enter"))
                people.add(name);
        }

        Collections.sort(people);
        for (int i = people.size() - 1; i >= 0; i--) {
            sb.append(people.get(i)).append("\n");
        }

        System.out.println(sb);
    }
}