package algorithm.sort.selectionsort;

public class SelectionSort {

    public static void sort(int[] array) {
        selectionSort(array, 0);
    }

    private static void selectionSort(int[] array, int start) {
        if (start >= array.length) {
            return;
        }

        int minIndex = start;
        for (int i = start; i < array.length; i++) {
            if (array[minIndex] > array[i]) {
                minIndex = i;
            }
        }

        int tmp = array[start];
        array[start] = array[minIndex];
        array[minIndex] = tmp;

        selectionSort(array, start + 1);
    }
}
