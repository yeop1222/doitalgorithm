package ch03.ch0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1253
public class Main008 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int answer=0;
        for(int i=0; i<N; i++) {
            int start=0;
            int end=N-1;
            while(start < end) {
                if(A[start] + A[end] > A[i]) {
                    end--;
                } else if (A[start] + A[end] < A[i]) {
                    start++;
                } else {
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);
    }
}
