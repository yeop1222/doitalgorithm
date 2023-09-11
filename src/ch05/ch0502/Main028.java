package ch05.ch0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1167
public class Main028 {

    static ArrayList<Edge>[] arrayLists;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arrayLists = new ArrayList[N+1];

        for (int i = 1; i <= N; i++) {
            arrayLists[i] = new ArrayList<>();
        }

        for(int i=1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            while(true) {
                int end = Integer.parseInt(st.nextToken());
                if(end == -1) {
                    break;
                }
                arrayLists[start].add(new Edge(end, Integer.parseInt(st.nextToken())));
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(1);
        int max = 1;
        for(int i=2; i<=N; i++) {
            if(distance[max] < distance[i]) {
                max = i;
            }
        }

        distance = new int[N+1];
        visited = new boolean[N+1];
        BFS(max);
        Arrays.sort(distance);
        System.out.println(distance[N]);
    }

    public static void BFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        visited[startNode] = true;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(Edge e : arrayLists[now]) {
                int node = e.node;
                if(!visited[node]) {
                    visited[node] = true;
                    queue.add(node);
                    distance[node] = distance[now] + e.distance;
                }
            }
        }
    }

    static class Edge {
        int node;
        int distance;

        public Edge(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
