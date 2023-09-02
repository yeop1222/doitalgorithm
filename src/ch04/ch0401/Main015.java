package ch04.ch0401;

import java.util.Scanner;

// 2750
public class Main015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N-1; i++) {
            for (int j = 0; j < N-1-i; j++) {
                if(A[j] > A[j+1]) {
                    int k = A[j];
                    A[j] = A[j+1];
                    A[j+1] = k;
                }
            }
        }

        for(int i : A) {
            System.out.println(i);
        }
    }
}
