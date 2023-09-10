package ch05.ch0501;

import java.util.Scanner;

// 2023
public class Main024 {

    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        DFS(2, 1);
        DFS(3, 1);
        DFS(5, 1);
        DFS(7, 1);
    }

    public static void DFS(int num, int digit) {
        if(digit == N) {
            if (isPrime(num)) {
                System.out.println(num);
            } else {
                return;
            }
        }

        for (int i = 1; i < 10; i+=2) {
            if(isPrime(num*10 + i)) {
                DFS(num*10 + i, digit+1);
            }
        }
    }

    public static boolean isPrime(int num) {

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
