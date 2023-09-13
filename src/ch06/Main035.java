package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1931
public class Main035 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Data[] A = new Data[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = new Data(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(A, (o1, o2) -> {
            if(o1.end == o2.end) {
                return o1.start - o2.start;
            }
            return o1.end - o2.end;
        });

        int answer = 0;
        int end = -1;
        for (int i = 0; i < N; i++) {
            if(A[i].start >= end) {
                answer++;
                end = A[i].end;
            }
        }
        System.out.println(answer);
    }

    static class Data {
        int start;
        int end;

        public Data(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
