package ch04.ch0402;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1427
public class Main017 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] A = br.readLine().toCharArray();

        for (int i = 0; i < A.length; i++) {
            int max = i;
            for (int j = i; j < A.length; j++) {
                if(A[max] < A[j]) {
                    max = j;
                }
            }
            char temp = A[max];
            A[max] = A[i];
            A[i] = temp;
        }
        for(char ch : A) {
            System.out.print(ch);
        }
    }

}
