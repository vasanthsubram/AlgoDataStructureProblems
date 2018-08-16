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
    assertTrue(bsearch(a, a[len - 1]) == len - 1);
    assertTrue(bsearch(a, a[0]) == 0);

    assertTrue(bsearch(a, 400) == 3);
    assertTrue(bsearch(a, 200) == 1);
    assertTrue(bsearch(a, 600) == 5);

    //non existing
    assertTrue(bsearch(a, 5500) == -1);


    //----recursive
    //edge cases
    assertTrue(bsearch(a, a[len - 1]) == len - 1);
    assertTrue(bsearch(a, a[0]) == 0);

    assertTrue(bsearch(a, 400) == 3);
    assertTrue(bsearch(a, 200) == 1);
    assertTrue(bsearch(a, 600) == 5);

    //non existing
    assertTrue(bsearch(a, 5500) == -1);

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

  //recursive
  public static int recSearch(int[] input, int target) {
    return _recSearch(input, target, 0, input.length - 1);
  }

  public static int _recSearch(int[] a, int t, int min, int max) {
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
    return _recSearch(a, t, min, max);
  }


  static int bsearch(int[] a, int x) {
    int max = a.length - 1, min = 0;

    return _bsearch(a, x, max, min);
  }

  static int _bsearch(int[] a, int x, int max, int min){

    if(max < min) return -1;

    int mid = (max + min)/2;

    if(x == a[mid]){
      return mid;
    }

    if(x < a[mid]){
      max = mid -1;
    } else{
      min = mid +1 ;
    }

    return _bsearch(a, x, max, min);
  }
}
