package 스터디2026.DP;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class _123더하기5_15990 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

  static int T;
  static int N;
  static long[][] dp;

  public static void main(String[] args) throws IOException {
    T = Integer.parseInt(br.readLine());

    //Test Case 마다 재사용 가능
    dp = new long[4][100000 + 1];

    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());
      bw.write(String.valueOf(getMethodNum(0, N)%1000000009));
      bw.newLine();
    }
    bw.flush();
  }

  public static long getMethodNum(int previousNum, int n) {
    if (n < 0) {
      return 0;
    }

    if (dp[previousNum][n] != 0) {
      return dp[previousNum][n];
    }
    if (n == 0) {
      dp[previousNum][n] = 1;
      return 1;
    }

    if (n == 1) {
      if (previousNum == 1) {
        dp[previousNum][n] = 0;
        return 0;
      }
      dp[previousNum][n] = 1;
      return 1;
    }
    else if (n == 2) {
      if (previousNum == 2) {
        dp[previousNum][n] = 0;
        return 0;
      }
      dp[previousNum][n] = 1;
      return 1;
    }

    long result = 0;
    for (int i = 1; i < 4; i++) {
      if (previousNum == i) continue;
      result += getMethodNum(i, n - i);
      if (result > 1000000009) {
        result = result%1000000009;
      }
    }

    dp[previousNum][n] = result;
    return result;
  }


}
