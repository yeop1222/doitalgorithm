package ch04.ch0406;

import java.io.*;

// 10989
public class Main022 {

    static int[] A;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        radixSort();

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }

    static void radixSort() {
        int[] tmp = new int[A.length];

        for (int i = 0, radix=1; i < 5; i++, radix*=10) {
            // 각 자리수에 해당하는 숫자 개수 배열
            int[] bucket = new int[10];
            for (int j = 0; j < A.length; j++) {
                bucket[((A[j] / radix) % 10)]++;
            }

            // 배열 누적
            for (int j = 1; j < 10; j++) {
                bucket[j] += bucket[j-1];
            }

            // 뒤에서부터 저장
            for (int j = A.length - 1; j >= 0; j--) {
                tmp[ bucket[(A[j] / radix) % 10] - 1 ] = A[j];
                bucket[(A[j] / radix) % 10]--;
            }

            // 현재 자리수까지 저장완료...
            for (int j = 0; j < A.length; j++) {
                A[j] = tmp[j];
            }
        }
    }
}
