package ch03.ch0303;

import java.util.Scanner;

// 2018
public class Main006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int start = 1;
        int end = 1;
        int result = 1;
        int sum = 1;

        while (end < N) {
            if (sum < N) {
                end++;
                sum += end;
            } else if (sum > N) {
                sum -= start;
                start++;
            } else {
                result++;
                end++;
                sum += end;
            }
        }

        System.out.println(result);
    }
}
