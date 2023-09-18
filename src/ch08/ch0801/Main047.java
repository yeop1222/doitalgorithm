package ch08.ch0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 1325
public class Main047 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        boolean[] visited;
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arrayLists[a].add(b);
        }

        int[] answer = new int[n+1];
        for (int i = 1; i <= n; i++) {
            visited = new boolean[n+1];

            // BFS
            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            visited[i] = true;
            while(!queue.isEmpty()) {
                int now = queue.poll();
                for (int j : arrayLists[now]) {
                    if(!visited[j]) {
                        visited[j] = true;
                        answer[j]++;
                        queue.add(j);
                    }
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            if(answer[i] > max) {
                max = answer[i];
            }
        }
        for (int i = 1; i <= n; i++) {
            if(answer[i] == max) {
                System.out.print(i + " ");
            }
        }
    }
}
