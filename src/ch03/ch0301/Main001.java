package ch03.ch0301;

import java.util.Scanner;

// 백준 11720
public class Main001 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String strNumber = scanner.next();
        char[] charNumber = strNumber.toCharArray();

        int sum = 0;
        for(char ch : charNumber) {
            sum += (ch-'0');
        }

        System.out.println(sum);
    }
}
