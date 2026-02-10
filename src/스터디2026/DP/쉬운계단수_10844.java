package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class 쉬운계단수_10844 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static long[][] dp;
  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    dp = new long[10][N];

    long result = 0;
    for (int i = 1; i < 10; i++) {
      result += getStairNumber(i, N - 1);
    }

    System.out.println(result%1000000000L);
  }

  public static long getStairNumber(int frontNum, int n) {
    if (n == 0) {
      dp[frontNum][n] = 1L;
      return 1L;
    }
    if (dp[frontNum][n] != 0L) {
      return dp[frontNum][n];
    }

    long result = 0L;
    if (frontNum == 9) {
      result = getStairNumber(frontNum - 1, n - 1);
    }
    else if (frontNum == 0) {
      result = getStairNumber(frontNum + 1, n - 1);
    }
    else {
      result = getStairNumber(frontNum - 1, n - 1) + getStairNumber(frontNum + 1, n - 1);
    }

    if (result > 1000000000L) {
      result = result % 1000000000L;
    }
    dp[frontNum][n] = result;
    return result;
  }
}
