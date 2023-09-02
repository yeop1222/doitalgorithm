package ch04.ch0401;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// 1377
public class Main016 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Data[] A = new Data[N];
        for (int i = 0; i < N; i++) {
            A[i] = new Data(i, Integer.parseInt(br.readLine()));
        }
        Arrays.sort(A);

        int max = 0;
        for (int i = 0; i < N; i++) {
            if(A[i].index - i > max) {
                max = A[i].index - i;
            }
        }

        System.out.println(max+1);
    }

    static class Data implements Comparable<Data>{
        int index;
        int value;

        public Data (int index, int value) {
            super();
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Data o2) {
            return this.value - o2.value;
        }
    }

}
