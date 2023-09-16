package ch07.ch0703;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 1033
public class Main044 {

    static ArrayList<Node>[] arrayList;
    static boolean[] visited;
    static long[] mass;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arrayList = new ArrayList[N];
        visited = new boolean[N];
        mass = new long[N];
        long lcm = 1;

        for (int i = 0; i < N; i++) {
            arrayList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            arrayList[a].add(new Node(b, p, q));
            arrayList[b].add(new Node(a, q, p));
            lcm *= p * q / gcd(p, q);
        }

        mass[0] = lcm;
        dfs(0);
        long cgcd = lcm;
        for (int i = 1; i < N; i++) {
            cgcd = gcd(cgcd, mass[i]);
        }
        for (int i = 0; i < N; i++) {
            System.out.print(mass[i] / cgcd + " ");
        }
    }

    public static long gcd(long p, long q) {
        if(q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    public static void dfs(int node) {
        visited[node] = true;
        for (Node i : arrayList[node]) {
            if(!visited[i.node]) {
                mass[i.node] = mass[node] * i.q / i.p;
                dfs(i.node);
            }
        }
    }

    static class Node {
        int node;
        int p;
        int q;

        public Node(int node, int p, int q) {
            this.node = node;
            this.p = p;
            this.q = q;
        }
    }
}
