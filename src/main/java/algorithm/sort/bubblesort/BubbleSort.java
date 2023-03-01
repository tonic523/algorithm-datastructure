package algorithm.sort.bubblesort;

public class BubbleSort {

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            bubbleSort(array, i);
        }
    }

    private static void bubbleSort(int[] array, int count) {
        for (int i = 0; i < array.length - count - 1; i++) {
            if (array[i] > array[i+1]) {
                int tmp = array[i];
                array[i] = array[i+1];
                array[i+1] = tmp;
            }
        }
    }
}
