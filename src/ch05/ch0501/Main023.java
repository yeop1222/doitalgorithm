package ch05.ch0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 11724
public class Main023 {

    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];

        // 인접리스트 초기화
        arrayList = new ArrayList[n+1];
        for (int i = 0; i < n+1; i++) {
            arrayList[i] = new ArrayList<>();
        }
        // 인접리스트 만들기
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arrayList[start].add(end);
            arrayList[end].add(start);
        }

        int answer = 0;
        for (int i = 1; i < n+1; i++) {
            if(!visited[i]) {
                answer++;
                DFS(i);
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int node) {
        if(visited[node]) {
            return;
        }
        visited[node] = true;
        for (int i : arrayList[node]) {
            if(!visited[i]) {
                DFS(i);
            }
        }
    }
}
