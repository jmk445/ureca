package basic.workshop;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1010 {
    
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[][] input = new int[T][2];

        for (int i = 0; i < T; i++) {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int[] line = new int[2];
            line[0] = Integer.parseInt(st.nextToken());
            line[1] = Integer.parseInt(st.nextToken());
            input[i] = line;
        }

        for (int i = 0; i < T; i++) {
            int N = input[i][0];
            int M = input[i][1];

            int[] src = new int[M];
            int[] tgt = new int[N];


            for (int j = 0; j < M; j++) {
                src[j] = j;
            }

            comb(0, 0, src, tgt);
            System.out.println(answer);
            answer = 0; 
        }
    }

    static void comb(int srcIdx, int tgtIdx, int[] src, int[] tgt) {

        if (tgtIdx == tgt.length) {
            answer++;
            return;
        }
 
        if (srcIdx == src.length) {
            return;
        }


        tgt[tgtIdx] = src[srcIdx];
        comb(srcIdx + 1, tgtIdx + 1, src, tgt);
        comb(srcIdx + 1, tgtIdx, src, tgt);
    }
}
