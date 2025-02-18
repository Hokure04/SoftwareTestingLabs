package task2;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class DijkstraAlgorithmTest {

    @Test
    void dijkstraGraph() {
        Map<Integer, List<DijkstraAlgorithm.Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new DijkstraAlgorithm.Edge(1,4), new DijkstraAlgorithm.Edge(2,1)));
        graph.put(1, Collections.singletonList(new DijkstraAlgorithm.Edge(3, 1)));
        graph.put(2, Arrays.asList(new DijkstraAlgorithm.Edge(1,2), new DijkstraAlgorithm.Edge(3,5)));
        graph.put(3, new ArrayList<>());

        Map<Integer, Integer> expectedDistances = new HashMap<>();
        expectedDistances.put(0, 0);
        expectedDistances.put(1, 3);
        expectedDistances.put(2, 1);
        expectedDistances.put(3, 4);
        Map<Integer, Integer> actualDistances = DijkstraAlgorithm.dijkstraGraph(graph, 0);
        assertEquals(expectedDistances, actualDistances);
    }
}