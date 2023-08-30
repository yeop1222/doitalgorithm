package ch03.ch0302;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 10986
public class Main005 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int N = Integer.parseInt(stringTokenizer.nextToken());
        int M = Integer.parseInt(stringTokenizer.nextToken());

        int[] remainder = new int[N+1];
        int[] count = new int[M];
        long result = 0;
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=1; i<=N; i++) {
            remainder[i] = (remainder[i-1] + Integer.parseInt(stringTokenizer.nextToken())) % M;
            if(remainder[i] == 0) {
                result++;
            }
            count[remainder[i]]++;
        }

        for(int i=0; i<M; i++) {
            result += (long) count[i] * (count[i] - 1) / 2;
        }

        System.out.println(result);

    }
}
