package ch03.ch0302;

import java.util.Scanner;

// 백준 11659
public class Main003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        long[] partialSum = new long[N + 1];
        for(int i=1; i<=N; i++) {
            partialSum[i] = partialSum[i-1] + scanner.nextInt();
        }

        for(int i=0; i<M; i++) {
            System.out.println(-partialSum[scanner.nextInt() - 1] + partialSum[scanner.nextInt()]);
        }
    }
}
