package ch05.ch0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main025 {

    static ArrayList<Integer>[] arrayList;
    static boolean[] visited;
    static boolean arrive;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        visited = new boolean[N];
        arrive = false;

        // 인접 리스트 초기화
        arrayList = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        // 인접 리스트 채우기
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            arrayList[start].add(end);
            arrayList[end].add(start);
        }

        // DFS 실행
        for (int i = 0; i < N; i++) {
            DFS(i, 1);

            if(arrive) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    public static void DFS(int node, int depth) {
        if(depth >= 5 || arrive) {
            arrive = true;
            return;
        }

        visited[node] = true;
        for(int i : arrayList[node]) {
            if(!visited[i]) {
                DFS(i, depth + 1);
            }
        }
        visited[node] = false;
    }
}
