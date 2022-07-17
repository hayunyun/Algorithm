import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int array[][]= new int[3][number];
        int notad;
        int ad;
        int pay;
        for(int i=0;i<number; i++) {
            int r = sc.nextInt();
            int e =sc.nextInt();
            int c= sc.nextInt();
            if(r>e-c) {
                System.out.println("do not advertise");
            }
            else if(r==e-c) {
                System.out.println("does not matter");
            }
            else {
                System.out.println("advertise");
            }
        }
    }
 
}