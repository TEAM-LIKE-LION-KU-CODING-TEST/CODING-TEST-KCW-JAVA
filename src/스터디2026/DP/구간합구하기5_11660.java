package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class 구간합구하기5_11660 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static int M;
  static int[][] graph;
  static int[][] dp;
  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    graph = new int[N + 1][N + 1];
    dp = new int[N + 1][N + 1];

    for (int i = 1; i < N + 1; i++) {
      StringTokenizer st1 = new StringTokenizer(br.readLine(), " ");
      for (int j = 1; j < N + 1; j++) {
        int currentY = Integer.parseInt(st1.nextToken());
        graph[i][j] = currentY;
        if (j == 1) {
          dp[i][j] = currentY;
        }
        else {
          dp[i][j] = dp[i][j - 1] + currentY;
        }
      }
    }
    for (int i = 0; i < M; i++) {
      StringTokenizer st2 = new StringTokenizer(br.readLine(), " ");
      int x1 = Integer.parseInt(st2.nextToken());
      int y1 = Integer.parseInt(st2.nextToken());
      int x2 = Integer.parseInt(st2.nextToken());
      int y2 = Integer.parseInt(st2.nextToken());

      int result = 0;
      for (int j = x1; j <= x2; j++) {
        result += dp[j][y2] - dp[j][y1 - 1];
      }
      bw.write(String.valueOf(result));
      bw.newLine();
    }
    bw.flush();
  }

}
