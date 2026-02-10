package 스터디2026.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 용돈관리_6236 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[] amounts;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    amounts = new int[N];
    int amountSum = 0;
    int maxAmount = 0;
    for (int i = 0; i < N; i++) {
      amounts[i] = Integer.parseInt(br.readLine());
      amountSum += amounts[i];

      if (amounts[i] > maxAmount) {
        maxAmount = amounts[i];
      }
    }

    System.out.println(binarySearch(maxAmount, amountSum));
  }

  public static int binarySearch(int left, int right) {
    int K = Integer.MAX_VALUE;

    while(left <= right) {
      int mid = (left + right) / 2;
      int currentK = possible(mid);
      if (currentK <= M) {
        right = mid - 1;
        if (K > mid) {
          K = mid;
        }
      }
      else {
        left = mid + 1;
      }
    }

    return K;
  }

  public static int possible(int k) {
    int currentAumount = k;
    int withdrawalCount = 1;
    for (int i = 0; i < N; i++) {
      if (currentAumount < amounts[i]) {
        currentAumount = k;
        withdrawalCount++;
      }
      currentAumount -= amounts[i];
    }

    return withdrawalCount;
  }

}
