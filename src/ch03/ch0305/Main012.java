package ch03.ch0305;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

// 17298
public class Main012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            while (!stack.empty() && A[i] > A[stack.peek()]) {
                B[stack.pop()] = A[i];
            }
            stack.push(i);
        }
        while(!stack.empty()) {
            B[stack.pop()] = -1;
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for(int i : B) {
            bw.write(i + " ");
        }
        bw.flush();
    }
}
