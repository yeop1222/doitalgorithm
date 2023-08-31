package ch03.ch0305;

import java.util.Scanner;
import java.util.Stack;

// 1874
public class Main011 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        for(int i=0; i<N; i++) {
            A[i] = sc.nextInt();
        }

        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int num = 1;
        for(int i=0; i<N; i++) {
            if(A[i] >= num) {
                while(A[i] >= num) {
                    stack.push(num);
                    num++;
                    sb.append("+\n");
                }
                stack.pop();
                sb.append("-\n");
            } else {
                if(stack.pop() == A[i]) {
                    sb.append("-\n");
                } else {
                    System.out.println("NO");
                    return;
                }
            }
        }

        System.out.println(sb);
    }
}
