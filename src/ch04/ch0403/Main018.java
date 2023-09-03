package ch04.ch0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11399
public class Main018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < N; i++) {
            int currNum = A[i];
            for (int j = i - 1; j >= 0; j--) {
                if(A[j] > currNum) {
                    A[j+1] = A[j];
                    A[j] = currNum;
                } else {
                    break;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            answer += A[i]*(N-i);
        }
        System.out.println(answer);
    }
}
