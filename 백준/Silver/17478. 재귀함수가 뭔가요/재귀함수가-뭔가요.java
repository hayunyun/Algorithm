import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException; 
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Comparator;

public class Main {
    static String line = "";
    public static void fun(int N) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        if (N >= 0) {
            // System.out.println(i);
            String plus = line;
            bw.write(plus + "\"재귀함수가 뭔가요?\"\n");
            if (N >= 1) {
                bw.write(plus + "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.\n");
                bw.write(plus + "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.\n");
                bw.write(plus + "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"\n");
                bw.flush();
            }
            else {
                // bw.write(N + "\n");
                bw.write(plus + "\"재귀함수는 자기 자신을 호출하는 함수라네\"\n");
                bw.flush();
            }
            line += "____";
            fun(N-1);
            bw.write(plus + "라고 답변하였지.\n");
            bw.flush();
        }
    }
    public static void main(String[] args) throws IOException {
        // StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int N = Integer.parseInt(br.readLine());
        
        bw.write("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.\n");
        bw.flush();
        fun(N);
    }
}

//1번
// you can also use imports, for example:
// import java.util.*;
// import java.io.*;

// // you can write to stdout for debugging purposes, e.g.
// // System.out.println("this is a debug message");

// class Solution {
//     public String solution(String S, int K) {
//         // write your code in Java SE 11
//         BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
//         String[] week = {"Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"};
//         int ans = (Arrays.asList(week).indexOf(S) + K%7) % 7; 
//         return week[ans];
//     }
// }


// 2번
// class Solution {
//     public boolean solution(int[] A, int K) {
//         int n = A.length;
//         for (int i = 0; i < n - 1; i++) {
//             if (A[i + 1] - A[i] > 1)
//                 return false;
//         }
//         if (A[0] != 1 || A[n - 1] != K)
//             return false;
//         else
//             return true;
//     }
// }


// 3번
// int[] D = {2,5};
//         String[] T = {"PGP", "M"};

//         // int[] D = {3, 2, 4};
//         // String[] T = {"MPM", "", "G"};

//         int time_p = 0;
//         int time_g = 0;
//         int time_m = 0;

//         for (int i=0; i<T.length; i++) {
//             if (T[i].contains("P")) {
//                 time_p += D[i] * 2;
//                 for (int j=0; j<T[i].length(); j++) {
//                     if (T[i].charAt(j) == 'P')
//                         time_p += 1;
//                 }
//             }
//             if (T[i].contains("G")) {
//                 time_g += D[i] * 2;
//                 for (int j=0; j<T[i].length(); j++) {
//                     if (T[i].charAt(j) == 'G')
//                         time_g += 1;
//                 }
//             }
//             if (T[i].contains("M")) {
//                 time_m += D[i] * 2;
//                 for (int j=0; j<T[i].length(); j++) {
//                     if (T[i].charAt(j) == 'M')
//                         time_m += 1;
//                 }
//             }
//         }
        
//         int max = Math.max(time_g, time_m);
//         max = Math.max(max, time_p);
//         bw.write(time_g + " " + time_m + " " + time_p + "\n");
//         bw.flush();


// if (max == apb[j]) {
//     bw.write("?");
// }

// /////
// import java.io.BufferedReader;
// import java.io.BufferedWriter;
// import java.io.InputStreamReader;
// import java.io.OutputStreamWriter;
// import java.io.IOException; 
// import java.util.Arrays;
// import java.util.StringTokenizer;

// BufferedReader bf = new BufferedReader(new InputStreamReader(System.in)); 
// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
// // StringTokenizer st; // 여러개를 입력받아 사용할 때

// String s = bf.readLine(); //String
// int n = Integer.parseInt(bf.readLine()); //Int

// String x = "abcdefg";   //출력할 문자열
// bw.write(s+ "\n"+ x+"\n");   //버퍼에 있는 값 전부 출력
// bw.flush();   //남아있는 데이터를 모두 출력시킴
// bw.write(String.valueOf(n)); // 숫자 출력 시!! 하나만 출력할땐 저렇게 하는데 문자열이랑 같이할땐 그냥 변수 그대로 써도 된다!
// bw.flush();
// bw.close();   //스트림을 닫음

// /////

//////
// BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
// BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));   
// StringTokenizer st;
// st = new StringTokenizer(br.readLine(), " ");
// int N = Integer.parseInt(st.nextToken());
// int X = Integer.parseInt(st.nextToken());
// int[] arr = new int[N];
// st = new StringTokenizer(br.readLine(), " ");
// for (int i=0; i<N; i++) {
//     arr[i] = Integer.parseInt(st.nextToken());
//     if (arr[i] < X) 
//         bw.write(arr[i] + " ");
// }
// bw.flush();
////////