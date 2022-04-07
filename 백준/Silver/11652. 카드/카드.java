import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        HashMap<Long, Integer> info = new HashMap<>();
        while(n-- > 0) {
            Long card = Long.parseLong(br.readLine());
            if (!info.containsKey(card))
                info.put(card, 1);
            else
                info.put(card, info.get(card) + 1);
        }

        List<Long> entry = new LinkedList<>(info.keySet());
        entry.sort(new Comparator<Long>() {
            @Override
            public int compare(Long key1, Long key2) {
                Integer val1 = info.get(key1);
                Integer val2 = info.get(key2);
                if (val1.equals(val2))
                    return key1.compareTo(key2); // 카드 개수 같으면 카드번호 오름차순
                else
                    return val2.compareTo(val1); // 카드 개수 다르면 개수 내림차순
            }
        });

        System.out.println(entry.get(0));
    }
}