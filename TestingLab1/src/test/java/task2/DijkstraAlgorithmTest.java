package task2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DijkstraAlgorithmTest {

    @Test
    void dijkstraGraph() {
        Map<Integer, List<DijkstraAlgorithm.Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new DijkstraAlgorithm.Edge(2,8), new DijkstraAlgorithm.Edge(3,3)));
        graph.put(1, Arrays.asList(new DijkstraAlgorithm.Edge(6, 2), new DijkstraAlgorithm.Edge(5,8)));
        graph.put(2, Arrays.asList(new DijkstraAlgorithm.Edge(0,8), new DijkstraAlgorithm.Edge(6,2)));
        graph.put(3, Arrays.asList(new DijkstraAlgorithm.Edge(0, 3), new DijkstraAlgorithm.Edge(7, 6)));
        graph.put(4, new ArrayList<>());
        graph.put(5, Arrays.asList(new DijkstraAlgorithm.Edge(1, 8), new DijkstraAlgorithm.Edge(7, 6)));
        graph.put(6, Arrays.asList(new DijkstraAlgorithm.Edge( 1, 2), new DijkstraAlgorithm.Edge(2, 2)));
        graph.put(7, Arrays.asList(new DijkstraAlgorithm.Edge(3, 6), new DijkstraAlgorithm.Edge(5, 6)));


        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(0, 0);
        expectedDistances.put(1, 12);
        expectedDistances.put(2, 8);
        expectedDistances.put(3, 3);
        expectedDistances.put(4, Integer.MAX_VALUE);
        expectedDistances.put(5, 15);
        expectedDistances.put(6, 10);
        expectedDistances.put(7, 9);
        Map<Integer, Integer> actualDistances = DijkstraAlgorithm.dijkstraGraph(graph, 0);
        assertEquals(expectedDistances, actualDistances);
    }
}