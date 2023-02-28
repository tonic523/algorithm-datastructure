package algorithm.sort.quicksort;

import java.util.Arrays;

public class QuickSort {

    public static void sort(int[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(int[] array, int start, int end) {
        System.out.println(Arrays.toString(array));
        int part2 = partition(array, start, end); // 분리한 파티션의 오른쪽 첫번째 위치값
        if (start < part2 - 1) { // 왼쪽 파티션의 원소가 2개 이상일 경우
            sort(array, start, part2 - 1);
        }
        if (part2 < end) { // 오른쪽 파티션의 원소가 2개 이상일 경우
            sort(array, part2, end);
        }
    }

    private static int partition(int[] array, int start, int end) {
        int pivot = array[(start + end) / 2];
        while (start <= end) {
            // swap 해야 하는 원소 찾기
            while (array[start] < pivot) start++;
            while (array[end] > pivot) end--;
            // 같으면 swap은 의미가 없지만, 다음 단계로 넘어가야 하기 때문에 존재한다.
            if (start <= end) {
                swap(array, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] array, int start, int end) {
        int tmp = array[start];
        array[start] = array[end];
        array[end] = tmp;
    }
}
