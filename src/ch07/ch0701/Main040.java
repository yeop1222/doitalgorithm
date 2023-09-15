package ch07.ch0701;

import java.util.Scanner;

// 1016
public class Main040 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long min = sc.nextLong();
        long max = sc.nextLong();

        boolean[] A = new boolean[(int) (max-min+1)];

        for (long i = 2; i <= Math.sqrt(max); i++) {
            long pow = i*i;
            for (long j = (long) Math.ceil((double)min/pow); j <= max/pow; j++) {
                A[(int) (j*pow - min)] = true;
            }
        }

        int answer = 0;
        for (int i = 0; i <= max-min; i++) {
            if(!A[i]) {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
