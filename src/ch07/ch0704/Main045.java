package ch07.ch0704;

import java.util.ArrayList;
import java.util.Scanner;

// 21568
public class Main045 {

    static ArrayList<Integer> q = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int gcd = gcd(a, b);
        if(c % gcd == 0) {
            int mult = c / gcd;

            int x = 1;
            int y = 0;
            for (int i = q.size() - 1; i >= 0; i--) {
                int x_ = y;
                int y_ = x - y * q.get(i);
                x = x_;
                y = y_;
            }

            System.out.println(x*mult + " " + y*mult);
        } else {
            System.out.println(-1);
        }
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        q.add(a / b);
        return gcd(b, a % b);
    }
}
