package ch07.ch0701;

import java.util.Scanner;

// 1747
public class Main039 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[1003002];
        for (int i = 2; i <= 1003001; i++) {
            A[i] = i;
        }

        for (int i = 2; i <= Math.sqrt(1003001); i++) {
            if(A[i] == 0) {
                continue;
            }
            for (int j = 2*i; j <= 1003001; j+=i) {
                A[j] = 0;
            }
        }

        for (int i = N; i <= 1003001; i++) {
            if(A[i] != 0) {
                char[] ch = String.valueOf(A[i]).toCharArray();
                boolean flag = true;
                for (int j = 0; j < ch.length/2; j++) {
                    if (ch[j] != ch[ch.length - 1 - j]) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    System.out.println(A[i]);
                    break;
                }
            }
        }
    }
}
