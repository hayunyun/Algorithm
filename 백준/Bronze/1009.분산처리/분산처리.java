import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));  
        int T = Integer.parseInt(br.readLine());
        for (int i=0; i<T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());   
            int b = Integer.parseInt(st.nextToken());  
            int ans=0;
            switch (a%10) {
                case 1:
                    ans = 1;
                    break;
                case 2:
                    switch (b%4) {
                        case 1:
                            ans = 2;
                            break;
                        case 2:
                            ans = 4;
                            break;
                        case 3:
                            ans = 8;
                            break;
                        case 0:
                            ans = 6;
                            break;
                    }
                    break;
                case 3:
                    switch (b%4) {
                        case 1:
                            ans = 3;
                            break;
                        case 2:
                            ans = 9;
                            break;
                        case 3:
                            ans = 7;
                            break;
                        case 0:
                            ans = 1;
                            break;
                    }
                    break;
                case 4:
                    if (b%2==0)
                        ans = 6;
                    else ans = 4;
                    break;
                case 5:
                    ans = 5;
                    break;
                case 6:
                    ans = 6;
                    break;
                case 7:
                    switch (b%4) {
                        case 1:
                            ans = 7;
                            break;
                        case 2:
                            ans = 9;
                            break;
                        case 3:
                            ans = 3;
                            break;
                        case 0:
                            ans = 1;
                            break;
                    }
                    break;
                case 8:
                    switch (b%4) {
                        case 1:
                            ans = 8;
                            break;
                        case 2:
                            ans = 4;
                            break;
                        case 3:
                            ans = 2;
                            break;
                        case 0:
                            ans = 6;
                            break;
                    }
                    break;
                case 9:
                    if (b%2==0)
                        ans = 1;
                    else ans = 9;
                    break;
                case 0:
                    ans = 10;
                    break;
            }

            bw.write(ans + "\n");
            bw.flush();
        }   
    }
}