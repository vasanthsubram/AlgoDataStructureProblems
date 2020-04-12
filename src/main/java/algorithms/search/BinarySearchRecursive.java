package algorithms.search;

import static org.junit.Assert.assertTrue;

public class BinarySearchRecursive {
  public static void main(String[] args) {

    int[] a = {100, 200, 300, 400, 500, 600, 700};
    int len = a.length;

    //edge cases
    assertTrue(search(a, a[len - 1]) == len - 1);
    assertTrue(search(a, a[0]) == 0);

    assertTrue(search(a, 400) == 3);
    assertTrue(search(a, 200) == 1);
    assertTrue(search(a, 600) == 5);

    //non existing
    assertTrue(search(a, 5500) == -1);

  }

  public static int search(int[] input, int target) {
    return _search(input, target, 0, input.length - 1);
  }

  public static int _search(int[] a, int t, int min, int max) {
    if (max < min) {
      return -1;
    }

    int mid = (min + max) / 2;

    if (t == a[mid]) {
      return mid;
    }

    if (t < a[mid]) {
      max = mid - 1;
    } else {
      min = mid + 1;
    }
    return _search(a, t, min, max);
  }
}
