package ch04.ch0403;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

//        quickSort(A, 0, N-1, K-1);
        Arrays.sort(A);
        System.out.println(A[K-1]);
    }

    public static void quickSort(int[] A, int start, int end, int K) {
        if(start < end) {
            int pivot = pivot(A, start, end);
            if(pivot == K) {
                return;
            } else if(pivot < K) {
                quickSort(A, start, pivot-1, K);
            } else {
                quickSort(A, pivot+1, end, K);
            }
        }
    }

    public static int pivot(int[] A, int start, int end) {
        if(start+1 == end) {
            if(A[start] > A[end]) {
                swap(A, start, end);
            }
            return end;
        }

        int M = (start+end) / 2;
        swap(A, start, M);
        int pivot = A[start];

        int i = start;
        for (int j = start + 1; j <= end; j++) {
            if(A[j] < pivot) {
                i++;
                swap(A, i, j);
            }
        }

        swap(A, start, i);
        return i;
    }

    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
