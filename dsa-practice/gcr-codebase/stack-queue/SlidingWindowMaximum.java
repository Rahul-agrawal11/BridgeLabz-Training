package stackAndQueue;
import java.util.*;

public class SlidingWindowMaximum {

    public static int[] maxSlidingWindow(int[] arr, int k) {
        if (arr == null || k <= 0) return new int[0];

        int n = arr.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // 1. Remove indices outside current window
            while (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }

            // 2. Remove smaller elements from back
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }

            // 3. Add current index
            deque.offerLast(i);

            // 4. Add max to result (window formed)
            if (i >= k - 1) {
                result[i - k + 1] = arr[deque.peekFirst()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] ans = maxSlidingWindow(arr, k);
        System.out.println(Arrays.toString(ans));
    }
}
