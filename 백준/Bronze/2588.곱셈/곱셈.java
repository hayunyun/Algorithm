import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int x = a*(b%10);
        int y = a*((b/10)%10);
        int z = a*(b/100);
        System.out.println(x);
        System.out.println(y);
        System.out.println(z);
        System.out.println(x+10*y+100*z);
    }
}