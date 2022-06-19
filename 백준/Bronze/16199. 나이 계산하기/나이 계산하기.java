import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int birthY = sc.nextInt();
        int birthM = sc.nextInt();
        int birthD = sc.nextInt();
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();

        int age = year - birthY;

        if (birthY == year) {
            System.out.println(age);
        } else {
            if (birthM > month) { 
                System.out.println(age - 1);
            } else if (birthM == month){
                if (birthD <= day) { 
                    System.out.println(age);
                } else {
                    System.out.println(age - 1);
                }
            } else {
                System.out.println(age);
            }
        }

        sb.append(age + 1).append("\n").append(age);
        System.out.println(sb);
    }
}
