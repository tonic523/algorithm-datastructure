package algorithm.sort.quicksort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class QuickSortTest {

    @DisplayName("퀵정렬로 배열을 정렬할 수 있다.")
    @Test
    void quickSort() {
        // given
        int[] array = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2, 10};

        // when
        QuickSort.sort(array);

        // then
        assertThat(array).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
