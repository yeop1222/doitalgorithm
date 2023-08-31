package ch03.ch0305;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.Scanner;

// 11286
public class Main014 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> {
            if(Math.abs(o1) == Math.abs(o2)) {
                return o1 > o2 ? 1 : -1;
            } else {
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < N; i++) {
            int num = sc.nextInt();
            if(num == 0) {
                if(priorityQueue.isEmpty()) {
                    bw.write("0\n");
                } else {
                    bw.write(priorityQueue.poll() + "\n");
                }
            } else {
                priorityQueue.add(num);
            }
        }
        bw.flush();
    }
}
