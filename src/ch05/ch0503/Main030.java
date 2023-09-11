package ch05.ch0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2343
public class Main030 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] A = new int[N];
        int start = 0;
        int end = 0;
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            if(start < A[i]) {
                start = A[i];
            }
            end += A[i];
        }

        while(start <= end) {
            int mid = (start + end) / 2;
            int sum = 0;
            int count = 1;

            // mid 개로 모두 저장 가능?
            for (int i = 0; i < N; i++) {
                if(sum + A[i] > mid) {
                    sum = 0;
                    count++;
                }
                sum += A[i];
            }

            if(sum == 0) {
                count--;
            }
            if(count > M) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start);
    }
}
