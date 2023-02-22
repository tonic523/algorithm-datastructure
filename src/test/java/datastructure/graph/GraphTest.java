package datastructure.graph;

import static org.assertj.core.api.Java6Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GraphTest {

    /**
     * 그래프 모양
     *    0
     *   /
     *  1 - 3 -  5 - 7
     *  | / |    |
     *  2 - 4    6 - 8
     */
    @DisplayName("DFS로 탐색할 수 있다.")
    @Test
    void dfs() {
        // given
        Graph graph = new Graph(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8));
        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 7);
        graph.addEdge(5, 6);
        graph.addEdge(6, 8);

        // when
        List<Integer> actual = graph.dfs(0);

        // then
        assertThat(actual).containsExactly(0, 1, 2, 4, 3, 5, 6, 8, 7);
    }

    /**
     * 그래프 모양
     *    0
     *   /
     *  1 - 3 -  5 - 7
     *  | / |    |
     *  2 - 4    6 - 8
     */
    @DisplayName("재귀를 활용하여 DFS 탐색할 수 있다.")
    @Test
    void dfsRecursive() {
        // given
        Graph graph = new Graph(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8));
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        // when
        List<Integer> actual = graph.dfsRecursive(0);

        // then
        assertThat(actual).containsExactly(0, 1, 2, 4, 3, 5, 6, 8, 7);
    }
    /**
     * 그래프 모양
     *    0
     *   /
     *  1 - 3 -  5 - 7
     *  | / |    |
     *  2 - 4    6 - 8
     */
    @DisplayName("BFS로 탐색할 수 있다.")
    @Test
    void bfs() {
        // given
        Graph graph = new Graph(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8));
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 4);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(5, 6);
        graph.addEdge(5, 7);
        graph.addEdge(6, 8);

        // when
        List<Integer> actual = graph.bfs(0);

        // then
        assertThat(actual).containsExactly(0, 1, 2, 3, 4, 5, 6, 7, 8);
    }
}
