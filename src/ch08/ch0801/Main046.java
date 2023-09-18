package ch08.ch0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 18352
public class Main046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] arrayLists = new ArrayList[n+1];
        int[] visited = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arrayLists[i] = new ArrayList<>();
        }
        for (int i = 1; i <= n; i++) {
            visited[i] = -1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayLists[a].add(b);
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(x);
        visited[x]++;
        ArrayList<Integer> answer = new ArrayList<>();
        while(!queue.isEmpty()) {
            int now = queue.poll();
            if(visited[now] == k) {
                answer.add(now);
            }
            for (int i : arrayLists[now]) {
                if(visited[i] == -1) {
                    visited[i] = visited[now] + 1;
                    queue.add(i);
                }
            }
        }

        if(answer.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(answer);
            for (int i : answer) {
                System.out.println(i);
            }
        }
    }
}
