package ch07.ch0702;

import java.util.Scanner;

// 11689
public class Main041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long answer = N;

        for (long i = 2; i <= Math.sqrt(N); i++) {
            if(N % i == 0) {
                answer -= answer / i;
                while (N % i == 0) {
                    N /= i;
                }
            }
        }

        if(N != 1) {
            answer -= answer / N;
        }
        System.out.println(answer);
    }
}
