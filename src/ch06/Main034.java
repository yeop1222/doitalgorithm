package ch06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

// 1744
public class Main034 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> plusQueue = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minusQueue = new PriorityQueue<>();
        int ones = 0;
        int zeros = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            if(num > 1) {
                plusQueue.add(num);
            } else if(num == 1) {
                ones++;
            } else if(num == 0) {
                zeros++;
            } else {
                minusQueue.add(num);
            }
        }

        int answer = 0;
        while(plusQueue.size() > 1) {
            answer += plusQueue.poll() * plusQueue.poll();
        }
        if(!plusQueue.isEmpty()) {
            answer += plusQueue.poll();
        }

        while(minusQueue.size() > 1) {
            answer += minusQueue.poll() * minusQueue.poll();
        }
        if(!minusQueue.isEmpty()) {
            if(zeros == 0) {
                answer += minusQueue.poll();
            }
        }

        answer += ones;
        System.out.println(answer);
    }
}
