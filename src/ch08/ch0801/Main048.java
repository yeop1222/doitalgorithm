package ch08.ch0801;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1707
public class Main048 {

    static ArrayList<Integer>[] arrayLists;
    static boolean[] visited;
    static boolean[] answer;
    static int[] checked;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        answer = new boolean[k];

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arrayLists = new ArrayList[v+1];
            visited = new boolean[v+1];
            checked = new int[v+1];
            for (int j = 1; j <= v; j++) {
                arrayLists[j] = new ArrayList<>();
            }

            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                arrayLists[a].add(b);
                arrayLists[b].add(a);
            }

            boolean evenGraph = true;
            for (int j = 1; j <= v; j++) {
                if(!dfs(j)) {
                    evenGraph = false;
                    break;
                }
            }

            if(evenGraph) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    public static boolean dfs(int node) {
        visited[node] = true;
        for (int i : arrayLists[node]) {
            if(!visited[i]) {
                checked[i] = (checked[node] + 1) % 2;
                if(!dfs(i)) {
                    return false;
                }
            } else if(checked[node] == checked[i]) {
                return false;
            }
        }
        return true;
    }
}
