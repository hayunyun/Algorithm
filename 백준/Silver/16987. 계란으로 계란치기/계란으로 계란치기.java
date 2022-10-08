import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	/*
	 * 계란으로 계란 치면 -> 각 계란의 내구도는 상대 계란의 무게만큼 깎임
	 * 내구도가 0 이하가 되는 순간 계란이 깨짐
	 * 
	 * 1. 가장 왼쪽의 계란을 든다
	 * 2. 든 계란으로 깨지지 않은 다른 계란 중 하나를 친다.
	 * 단, 손에 든 계란이 깨졌거나 / 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
	 * 이후 손에 든 계란을 원래 자리에 내려놓는다.
	 * 3. 가장 최근에 든 계란의 한칸 오른쪽 계란을 손에 들고 2번을 다시 진행.
	 * 단, 가장 최근에 든 계란이 가장 오른쪽에 위치할 경우 과정 종료.
	 * 
	 * 최대 몇개의 계란을 깰 수 있는가?
	 */
	static class Egg {
		int h, w; // 내구도, 무게
		
		public Egg(int h, int w) {
			this.h = h;
			this.w = w;
		}
	}
	static int n, maxEgg;
	static Egg[] Eggs;
	public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        n = Integer.parseInt(br.readLine());
        Eggs = new Egg[n];
        for (int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	int h = Integer.parseInt(st.nextToken());
        	int w = Integer.parseInt(st.nextToken());
        	Eggs[i] = new Egg(h, w);
        }
        
//        System.out.println("기존: ");
//        print();
        
        // 가장 왼쪽의 계란부터 들고, 깨지지 않은 다른 계란을 친다
        maxEgg = Integer.MIN_VALUE;
    	crush(0);        	
        System.out.println(maxEgg == Integer.MAX_VALUE ? 0 : maxEgg);
	}
	
	static void crush(int idx) {	
		int cur = calcEgg();
//			System.out.println("최종 : " + cur);
		maxEgg = Math.max(maxEgg, cur);
		
		if (idx == n) {
			// 내구도가 0 이하인 계란 개수 세기
//			print();
			return;
		}
		
		
		if (Eggs[idx].h <= 0) {
			crush(idx+1);
			return;
		}
		
		// 깨지지 않은 다른 계란 하나 선택
//		System.out.println("idx : " + idx);
		for (int i = 0; i < n; i++) {
			if (idx == i) continue;
			if (Eggs[i].h <= 0) continue;
			
//			System.out.println(idx + "번째 계란과 " + i + "번째 계란 부딪히기");
			Eggs[idx].h -= Eggs[i].w;
			Eggs[i].h -= Eggs[idx].w;
			
//			print();
			crush(idx + 1);
			
			Eggs[idx].h += Eggs[i].w;
			Eggs[i].h += Eggs[idx].w;
//			System.out.println("------------------------");
		}
	}
	
	private static int calcEgg() {
		int cnt = 0;
		for (Egg e : Eggs) {
			if (e.h <= 0) cnt++;
		}
		
		return cnt;
	}
	
	static void print() {
		for (int i = 0; i < n; i++) {
			System.out.print(Eggs[i].h + " ");
		}
		System.out.println();
		System.out.println("-----------------------");
	}

}
