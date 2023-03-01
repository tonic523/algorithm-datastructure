package algorithm.sort.bubblesort;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {

    @DisplayName("버블 정렬로 요소를 정렬한다.")
    @Test
    void bubbleSort() {
        // given
        int[] array = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2, 10};

        // when
        BubbleSort.sort(array);

        // then
        assertThat(array).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }
}
