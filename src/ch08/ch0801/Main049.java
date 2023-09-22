package ch08.ch0801;

import java.util.*;

// 2251
public class Main049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] input = new int[3];
        input[0] = sc.nextInt();
        input[1] = sc.nextInt();
        input[2] = sc.nextInt();
        boolean[][] visited = new boolean[input[0]+1][input[1]+1];
        List<Integer> answer = new ArrayList<>();

        int[] donor = {0, 0, 1, 1, 2, 2};
        int[] receiver = {1, 2, 0, 2, 0, 1};

        Queue<Data> queue = new LinkedList<>();
        queue.add(new Data(0, 0));
        visited[0][0] = true;
        answer.add(input[2]);
        while(!queue.isEmpty()) {
            Data tmp = queue.poll();
            int p = tmp.a;
            int q = tmp.b;
            int r = input[2] - p - q;

            for (int i = 0; i < 6; i++) {
                int[] now = {p, q, r};

                now[receiver[i]] += now[donor[i]];
                now[donor[i]] = 0;
                if(now[receiver[i]] > input[receiver[i]]) {
                    now[donor[i]] = now[receiver[i]] - input[receiver[i]];
                    now[receiver[i]] = input[receiver[i]];
                }
                if(!visited[now[0]][now[1]]) {
                    visited[now[0]][now[1]] = true;
                    queue.add(new Data(now[0], now[1]));
                    if(now[0] == 0) {
                        answer.add(now[2]);
                    }
                }
            }

        }

        Collections.sort(answer);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }

    static class Data {
        int a;
        int b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }
}
