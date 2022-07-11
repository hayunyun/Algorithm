import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;
 
 
class Main {
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);            
       int sum=0;
       int cnt=3;
       int sum1=0;
       for(int i=1;i<7;i++) {
           int a=sc.nextInt();
           sum+= a*cnt;
           cnt--;
           if(i==3) {
               sum1=sum;
               cnt=3;
               sum=0;
       }      
    }
       if(sum1==sum) {
           System.out.println("T");
       }
       else {
           System.out.println(sum1>sum?"A":"B");
       }
}
}