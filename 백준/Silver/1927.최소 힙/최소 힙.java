import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        int N = Integer.parseInt(br.readLine());
        MinHeap mh = new MinHeap();
        
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                System.out.println(mh.delete());
            }
            else {
                mh.insert(x);
            }
        }
    }

}

class MinHeap {
    List<Integer> list;

    public MinHeap() {
        list = new ArrayList<>();
        list.add(0); // index 0은 안쓰기 때문
    }

    public void insert(int val) {
        // 1. leaf 마지막에 삽입
        list.add(val);
        int current = list.size() - 1; // 현재(마지막) 값의 인덱스 가져오기
        int parent = current / 2; // 부모 노드
        // 2. 부모와 비교 후 조건에 맞지 않으면 swap
        // 3. 조건이 만족되거나 root까지 반복
        while (true) {
            if (parent == 0 || list.get(parent) <= list.get(current)) { // root에 도착했거나, 부모가 자신보다 작다면 -> 조건 만족
                break;
            }
            // root도 아니고 부모가 자신보다 크다면
            int temp = list.get(parent);
            list.set(parent, list.get(current));
            list.set(current, temp); // swap

            current = parent; // 위로 올라감
            parent = current / 2; // 부모는 더 위로
        }
    }

    public int delete() {
        if (list.size() == 1) {
            return 0;
        }
        int top = list.get(1);
        // 1.root에 leaf 마지막 데이터 가져옴
        list.set(1, list.get(list.size() - 1));
        list.remove(list.size() - 1); // 가져온 후 지워주기
        // 2. 자식과 비교 후 조건이 맞지 않으면 swap
        // 3. 조건이 만족되거나 leaf에 도착할때까지 반복
        int currentPos = 1;
        while (true) {
            int leftPos = currentPos * 2; // 왼쪽자식의 인덱스
            int rightPos = currentPos * 2 + 1; // 오른쪽자식의 인덱스

            // 자식 존재 유무 확인 (왼쪽이 없으면 오른쪽도 없다. = 자식이 없다 -> 현재 current가 leaf)
            if (leftPos >= list.size()) {
                break;
            }
            // 왼쪽 자식 먼저 확인 (이제 왼쪽은 무조건 있다)
            int minValue = list.get(leftPos);
            int minPos = leftPos;

            // 오른쪽 자식 확인
            if (rightPos < list.size() && list.get(rightPos) < minValue) { // 오른쪽 자식이 존재하는지 확인(필수. 안하면 인덱스오류) && 최소값보다 작다면
                minValue = list.get(rightPos); // 최소값을 오른쪽 자식으로 변경
                minPos = rightPos;
            }

            //swap
            if (list.get(currentPos) > minValue) {
                int temp = list.get(currentPos);
                list.set(currentPos, minValue);
                list.set(minPos, temp); 
                currentPos = minPos;
            }
            else { // 조건 만족으로 스왑 불필요
                break;
            }
        }
        return top;
    }
}