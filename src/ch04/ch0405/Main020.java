package ch04.ch0405;

import java.io.*;

// 2751
public class Main020 {

    static int[] A;
    static int[] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        A = new int[N];
        tmp = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N-1);

        for (int i = 0; i < N; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
    }

    static void mergeSort(int start, int end) {
        if (end - start < 1) {
            return;
        }
        int m = (start + end) / 2;
        mergeSort(start, m);
        mergeSort(m+1, end);
        for (int i = start; i <= end; i++) {
            tmp[i] = A[i];
        }

        int indexA = start;
        int index1 = start;
        int index2 = m+1;
        while (index1 <= m && index2 <= end) {
            if(tmp[index1] < tmp[index2]) {
                A[indexA] = tmp[index1];
                indexA++;
                index1++;
            } else {
                A[indexA] = tmp[index2];
                indexA++;
                index2++;
            }
        }

        while(index1 <= m) {
            A[indexA] = tmp[index1];
            indexA++;
            index1++;
        }
        while(index2 <= end) {
            A[indexA] = tmp[index2];
            indexA++;
            index2++;
        }
    }
}
