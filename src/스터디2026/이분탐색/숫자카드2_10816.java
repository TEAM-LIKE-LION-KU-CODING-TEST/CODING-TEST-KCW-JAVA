package 스터디2026.이분탐색;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class 숫자카드2_10816 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
  static int N;
  static int M;
  static TreeMap<Integer, Integer> map = new TreeMap<>();

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");

    for (int i = 0; i < N; i++) {
      int cardKey = Integer.parseInt(st.nextToken());
      map.merge(cardKey, 1, Integer::sum);
    }

    M = Integer.parseInt(br.readLine());
    st = new StringTokenizer(br.readLine(), " ");
    for (int j = 0; j < M; j++) {
      int testCardKey = Integer.parseInt(st.nextToken());
      bw.write(String.valueOf(Objects.requireNonNullElse(map.get(testCardKey), 0)));
      bw.write(" ");
    }
    bw.flush();
  }
}
