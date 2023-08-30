package ch03.ch0301;

import java.util.Scanner;

// 백준 1546
public class Main002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();

        int sum = 0;
        int max = 0;
        for(int i=0; i<count; i++) {
            int num = scanner.nextInt();
            sum += num;
            if(num > max) {
                max = num;
            }
        }

        System.out.println((double)sum/count*100/max);
    }
}
