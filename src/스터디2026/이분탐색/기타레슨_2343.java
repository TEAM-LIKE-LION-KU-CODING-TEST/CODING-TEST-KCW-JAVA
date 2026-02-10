package 스터디2026.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 기타레슨_2343 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N;
  static int M;
  static int[] minutes;

  public static void main(String[] args) throws IOException {
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    minutes = new int[N];

    int totalVideoTime = 0;
    st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      minutes[i] = Integer.parseInt(st.nextToken());
      totalVideoTime += minutes[i];
    }

    System.out.println(binarySearch(0, totalVideoTime));
  }

  public static int binarySearch(int left, int right) {
    int min = Integer.MAX_VALUE;

    while (left <= right) {
      int mid = (left + right) / 2;
      int[] blueLaySizeAndMaxSize = possible(mid);
      if (blueLaySizeAndMaxSize[0] <= M) {
        if (min > blueLaySizeAndMaxSize[1]) {
          min = blueLaySizeAndMaxSize[1];
        }
        right = mid - 1;
      }
      else {
        left = mid + 1;
      }
    }

    return min;
  }

  public static int[] possible(int value) {
    int partSum = 0;
    int maxBlueLayPartSize = 0;
    int blueLayPartSize = 0;
    for (int i = 0; i < N; i++) {
      if (partSum + minutes[i] > value) {
        blueLayPartSize++;
        if (maxBlueLayPartSize < partSum) {
          maxBlueLayPartSize = partSum;
        }
        partSum = minutes[i];
        continue;
      }
      partSum += minutes[i];
    }

    blueLayPartSize++;
    if (maxBlueLayPartSize < partSum) {
      maxBlueLayPartSize = partSum;
    }


    return new int[] {blueLayPartSize, maxBlueLayPartSize};
  }
}
