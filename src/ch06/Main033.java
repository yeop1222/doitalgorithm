package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

// 1715
public class Main033 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int answer = 0;
        while(pq.size() > 1) {
            int a = pq.poll();
            int b = pq.poll();
            answer += a + b;
            pq.add(a+b);
        }
        System.out.println(answer);
    }
}
