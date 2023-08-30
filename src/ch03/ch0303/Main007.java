package ch03.ch0303;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1940
public class Main007 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] num = new int[N];
        for(int i=0; i<N; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num);

        int start = 0;
        int end = N - 1;
        int answer = 0;
        while(start < end) {
            if(num[start] + num[end] > M) {
                end--;
            } else if(num[start] + num[end] < M) {
                start++;
            } else {
                answer++;
                start++;
                end--;
            }
        }

        System.out.println(answer);
    }
}
