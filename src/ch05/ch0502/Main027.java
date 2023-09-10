package ch05.ch0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 2178
public class Main027 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] A = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                A[i][j] = Integer.parseInt(line.substring(j, j+1));
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            int[] now = queue.poll();

            // left
            if(now[0] > 0 && A[now[0]-1][now[1]] != 0 && !visited[now[0]-1][now[1]]) {
                visited[now[0]-1][now[1]] = true;
                A[now[0]-1][now[1]] = A[now[0]][now[1]] + 1;
                queue.add(new int[] {now[0]-1, now[1]});
            }
            // right
            if(now[0] < N-1 && A[now[0]+1][now[1]] != 0 && !visited[now[0]+1][now[1]]) {
                visited[now[0]+1][now[1]] = true;
                A[now[0]+1][now[1]] = A[now[0]][now[1]] + 1;
                queue.add(new int[] {now[0]+1, now[1]});
            }
            // up
            if(now[1] > 0 && A[now[0]][now[1]-1] != 0 && !visited[now[0]][now[1]-1]) {
                visited[now[0]][now[1]-1] = true;
                A[now[0]][now[1]-1] = A[now[0]][now[1]] + 1;
                queue.add(new int[] {now[0], now[1]-1});
            }
            // down
            if(now[1] < M-1 && A[now[0]][now[1]+1] != 0 && !visited[now[0]][now[1]+1]) {
                visited[now[0]][now[1]+1] = true;
                A[now[0]][now[1]+1] = A[now[0]][now[1]] + 1;
                queue.add(new int[] {now[0], now[1]+1});
            }
        }
        System.out.println(A[N-1][M-1]);

    }

}
