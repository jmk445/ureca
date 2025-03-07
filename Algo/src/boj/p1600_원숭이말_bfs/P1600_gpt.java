package boj.p1600_원숭이말_bfs;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1600_gpt {
    static int[][] board;
    static int[] dy_horse = {2, 2, 1, -1, -2, -2, 1, -1};
    static int[] dx_horse = {-1, 1, -2, -2, -1, 1, 2, 2};
    static int[] dy = {1, 0, -1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int W, H, K;
    static boolean[][][] visit; // (y, x, 말 이동 횟수)
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        K = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        board = new int[H][W];
        visit = new boolean[H][W][K + 1];

        for (int j = 0; j < H; j++) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < W; i++) {
                board[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = bfs();
        System.out.println(answer);
    }

    static class Node {
        int y, x, k, len;
        public Node(int y, int x, int k, int len) {
            this.y = y;
            this.x = x;
            this.k = k; // 현재까지 말처럼 이동한 횟수
            this.len = len; // 현재까지 이동한 거리
        }
    }

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 0));
        visit[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            
            // 도착지점 확인
            if (cur.y == H - 1 && cur.x == W - 1) {
                return cur.len;
            }

            // 일반 이동 (4방향)
            for (int d = 0; d < 4; d++) {
                int ny = cur.y + dy[d];
                int nx = cur.x + dx[d];

                if (ny < 0 || ny >= H || nx < 0 || nx >= W || visit[ny][nx][cur.k] || board[ny][nx] == 1) {
                    continue;
                }

                visit[ny][nx][cur.k] = true;
                queue.offer(new Node(ny, nx, cur.k, cur.len + 1));
            }

            // 말처럼 이동 (8방향) - K번까지 가능
            if (cur.k < K) {
                for (int d = 0; d < 8; d++) {
                    int ny = cur.y + dy_horse[d];
                    int nx = cur.x + dx_horse[d];

                    if (ny < 0 || ny >= H || nx < 0 || nx >= W || visit[ny][nx][cur.k + 1] || board[ny][nx] == 1) {
                        continue;
                    }

                    visit[ny][nx][cur.k + 1] = true;
                    queue.offer(new Node(ny, nx, cur.k + 1, cur.len + 1));
                }
            }
        }

        return -1; // 도착할 수 없는 경우
    }
}
