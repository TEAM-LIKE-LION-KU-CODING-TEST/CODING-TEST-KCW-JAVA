package 스터디2026.이분탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 예산_2512 {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static int N ;
  static int M;
  static List<Integer> budgets;
  static int MAX_REQUEST_BUDGET = 0;

  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    budgets = new ArrayList<>();
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    for (int i = 0; i < N; i++) {
      int currentRequestBudget = Integer.parseInt(st.nextToken());
      budgets.add(currentRequestBudget);
      if (MAX_REQUEST_BUDGET < currentRequestBudget) {
        MAX_REQUEST_BUDGET = currentRequestBudget;
      }
    }
    Collections.sort(budgets);

    M = Integer.parseInt(br.readLine());

    System.out.println(parametricSearch(0, MAX_REQUEST_BUDGET));
  }

  public static int parametricSearch(int left, int right) {
    int answer = 0;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (possible(mid)) {
        answer = mid;
        left = mid + 1;
      }
      else {
        right = mid - 1;
      }
    }

    return answer;
  }

  public static boolean possible(int upperBoundBudget) {
    int agreedBudgetSum = 0;
    for (int i = 0; i < N; i++) {
      if (budgets.get(i) >= upperBoundBudget) {
        agreedBudgetSum += upperBoundBudget * (N - i);
        break;
      }
      else {
        agreedBudgetSum += budgets.get(i);
      }
    }

    return agreedBudgetSum <= M;
  }

}
