package ch05.ch0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1260
public class Main026 {

    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startNode = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList[start].add(end);
            arrayList[end].add(start);
        }

        for (int i = 1; i < N+1; i++) {
            Collections.sort(arrayList[i]);
        }

        visited = new boolean[N+1];
        DFS(startNode);
        System.out.println();
        visited = new boolean[N+1];
        BFS(startNode);
    }

    public static void DFS(int node) {
        System.out.print(node + " ");
        visited[node] = true;
        for(int i : arrayList[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int node) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node);
        visited[node] = true;

        while(!queue.isEmpty()) {
            int num = queue.poll();
            System.out.print(num + " ");
            for(int i : arrayList[num]) {
                if(!visited[i]) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }
}
