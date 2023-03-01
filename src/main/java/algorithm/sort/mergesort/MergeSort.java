package algorithm.sort.mergesort;

public class MergeSort {

    public static void sort(int[] arr) {
        int[] tmp = new int[arr.length];
        mergeSort(arr, tmp, 0, arr.length - 1);
    }

    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }

    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        // tmp에 초기화
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        // 파트를 나눔
        int part1 = start;
        int part2 = mid + 1;
        int index = start;
        // 두 파트 중 끝이 도달한 경우일 때까지
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            } else {
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        // 만약 뒤쪽은 끝까지 갔고 앞쪽은 남아있을 경우
        for (int i = 0; i <= mid - part1; i++) {
            arr[index + i] = tmp[part1 + i];
        }
        // 뒤쪽이 남아있을 경우에는 굳이 바꿔주지 않아도 되기 때문에 따로 초기화해줄 필요가 없다.
    }
}
