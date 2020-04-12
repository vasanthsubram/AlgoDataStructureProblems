package algorithms.search;

import static org.junit.Assert.assertTrue;

/**
 * min    mid    max
 * Return the position of the target in the input array
 * If the target is not present, return -1
 */

public class BinarySearch {

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


  public static int search(int[] a, int t) {
    int min = 0, max = a.length - 1;
    int mid;

    //comparison here must be >= ; otherwise it fails, when target is at min=max=mid
    while (max >= min) {
      mid = (min + max) / 2;

      if (t == a[mid]) {
        return mid;
      }
      if (t < a[mid]) {
        max = mid - 1;
      } else {
        min = mid + 1;
      }
    }
    return -1;
  }

}
