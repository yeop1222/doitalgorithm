package ch05.ch0503;

import java.util.Scanner;

// 1300**
public class Main031 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long k = sc.nextLong();

        long start = 1;
        long end = k;
        long answer = 0;
        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 1; i <= N; i++) {
                cnt += Math.min(N, mid/i);
            }
            if(cnt < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
                answer = mid;
            }
        }
        System.out.println(answer);
    }
}
