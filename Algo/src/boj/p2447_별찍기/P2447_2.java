package boj.p2447_별찍기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//분할 정복
public class P2447_2 {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());		
		star(N);
	}
	
	static void star(int N) {
		if(N == 1) {
			return;
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(i >= N/3 && i <= 2*N/3 && j >= N/3 && j <= 2*N/3) {
					System.out.print(" ");					
				}else {
					System.out.print("*");
					star(N/3);
				}				
			}
			System.out.println();
		}
	}
}
//
//package boj.p2447;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//// 분할 정복
//public class P2447_2 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int N = Integer.parseInt(br.readLine());
//        
//        StringBuilder sb = new StringBuilder();
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (isBlank(i, j, N)) {
//                    sb.append(' ');
//                } else {
//                    sb.append('*');
//                }
//            }
//            sb.append('\n');
//        }
//        System.out.print(sb);
//    }
//
//    static boolean isBlank(int x, int y, int size) {
//        while (size > 1) {
//            if ((x % 3 == 1) && (y % 3 == 1)) {
//                return true;
//            }
//            x /= 3;
//            y /= 3;
//            size /= 3;
//        }
//        return false;
//    }
//}
