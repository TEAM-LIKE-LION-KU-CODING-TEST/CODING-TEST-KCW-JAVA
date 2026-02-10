package 스터디2026.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 두용액_2470 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int[] features;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    features = new int[N];

    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      features[i] = Integer.parseInt(st.nextToken());
    }

    Arrays.sort(features);

    int min = Integer.MAX_VALUE;
    int selectFeatureIndex = 0;
    int theOtherFeatureIndex = 0;

    for (int i = 0; i < N - 1; i++) {
      int[] minSumAndTheOtherIndex;
      if (features[i] >= 0) minSumAndTheOtherIndex = new int[]{features[i] + features[i + 1], i + 1};
      else minSumAndTheOtherIndex = binarySearch(i + 1, N - 1, features[i]);

      if (minSumAndTheOtherIndex[0] <= min) {
        min = minSumAndTheOtherIndex[0];
        selectFeatureIndex = i;
        theOtherFeatureIndex = minSumAndTheOtherIndex[1];
      }

      if (features[i] >= 0) break;
    }

    System.out.println(features[selectFeatureIndex] +" "+features[theOtherFeatureIndex]);
  }

  public static int[] binarySearch(int left, int right, int selectFeature) {
    int target = -selectFeature;
    int l = left;
    int r = right;
    while (l < r) {
      int mid = (l + r) / 2;
      if (features[mid] >= target) {
        r = mid;
      }
      else {
        l = mid + 1;
      }
    }

    int bestAbs = Integer.MAX_VALUE;
    int bestIdx = left;
    if (l <= right) { // pos 존재
      int abs = Math.abs(features[l] + selectFeature);
      if (abs < bestAbs) {
        bestAbs = abs;
        bestIdx = l;
      }
    }
    if (l - 1 >= left) { // pos-1 존재
      int abs = Math.abs(features[l - 1] + selectFeature);
      if (abs < bestAbs) {
        bestAbs = abs;
        bestIdx = l - 1;
      }
    }
    return new int[]{bestAbs, bestIdx};
  }
}
