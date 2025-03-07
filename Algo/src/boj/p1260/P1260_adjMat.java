
package boj.p1260;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1260_adjMat {
    static boolean[] visited;
    static int[][] graph;
    static int N;
    static int M;
    static int V;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new int[N + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            graph[left][right] = 1;
            graph[right][left] = 1;
        }

        dfs(V);
        System.out.println();
        visited = new boolean[N + 1];
        bfs(V);
    }

    public static void dfs(int V) {
        visited[V] = true;
        System.out.print(V + " ");
        for (int i = 1; i <= N; i++) {
            if (graph[V][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int V) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(V);
        visited[V] = true;
        System.out.print(V + " ");
        while (!q.isEmpty()) {
            V = q.poll();

            for (int i = 1; i <= N; i++) {
                if (graph[V][i] == 1 && !visited[i]) {
                    System.out.print(i + " ");
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }
}