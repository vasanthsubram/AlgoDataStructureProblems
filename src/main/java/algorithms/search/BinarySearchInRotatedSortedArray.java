package algorithms.search;

public class BinarySearchInRotatedSortedArray {

    public static void main(String args[]) {
        // Let us search 3 in below array
        int arr1[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int n = arr1.length;
        int key = 3;
        System.out.println("Index of the element is : " + pivotedBinarySearch(arr1, n, key));
    }

    /* Searches an element key in a pivoted sorted array arrp[]  of size n */
    static int pivotedBinarySearch(int arr[], int n, int key) {
        int pivot = findPivot(arr, 0, n-1);

        // If we didn't find a pivot, then array is not rotated at all
        if (pivot == -1)
            return binarySearch(arr, 0, n-1, key);

        // If we found a pivot, first compare with pivot and then search in two subarrays around pivot
        if (arr[pivot] == key)
            return pivot;
        if (arr[0] <= key)
            return binarySearch(arr, 0, pivot-1, key);
        return binarySearch(arr, pivot+1, n-1, key);
    }

    //pivot element is the only element for which next element to it is smaller than it.
    static int findPivot(int arr[], int min, int max) {
        if (max < min) return -1;
        if (max == min) return min;

        int mid = (min + max)/2;
        if (mid < max && (arr[mid] > arr[mid + 1]))
            return mid;
        if (mid > min && (arr[mid] < arr[mid - 1]))
            return (mid-1);
        if (arr[min] >= arr[mid])
            return findPivot(arr, min, mid-1);

        return findPivot(arr, mid + 1, max);
    }

    /* Standard Binary Search function */
    static int binarySearch(int arr[], int min, int max, int key) {
        if (max < min)
            return -1;

        int mid = (min + max)/2;
        if (key == arr[mid])
            return mid;
        if (key > arr[mid])
            return binarySearch(arr, (mid + 1), max, key);
        return binarySearch(arr, min, (mid -1), key);
    }
}
