package ch05.ch0503;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1920
public class Main029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(A);

        int M = Integer.parseInt(br.readLine());
        int[] B = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            int start = 0;
            int end = N-1;
            int find = 0;

            while(start <= end) {
                int mid = (start + end) / 2;
                if(A[mid] == B[i]) {
                    find = 1;
                    break;
                } else if(A[mid] > B[i]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(find);
        }
    }
}
