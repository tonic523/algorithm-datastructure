package algorithm.sort.selectionsort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SelectionSortTest {

    @DisplayName("선택정렬로 정렬한다.")
    @Test
    void selectionSort() {
        // given
        int[] array = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2, 10};

        // when
        SelectionSort.sort(array);

        // then
        assertThat(array).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
