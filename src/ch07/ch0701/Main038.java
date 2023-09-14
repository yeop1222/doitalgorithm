package ch07.ch0701;

import java.util.Scanner;

// 1456
public class Main038 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();

        int[] N = new int[(int)Math.sqrt(B) + 1];
        for (int i = 2; i <= Math.sqrt(B); i++) {
            N[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(B); i++) {
            if(N[i] == 0) {
                continue;
            }
            for (int j = 2*i; j <= Math.sqrt(B); j+=i) {
                N[j] = 0;
            }
        }

        int answer = 0;
        for (int i = 2; i <= Math.sqrt(B); i++) {
            if(N[i] != 0) {
                long temp = N[i];
                while ((double)N[i] <= (double)B/temp) {
                    if ((double)N[i] >= (double)A/temp) {
                        answer++;
                    }
                    temp *= N[i];
                }
            }
        }
        System.out.println(answer);
    }
}
