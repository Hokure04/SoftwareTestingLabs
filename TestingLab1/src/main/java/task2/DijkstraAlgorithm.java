package task2;

import java.util.*;

public class DijkstraAlgorithm {

    public static class Edge{
        public int target, weight;
        public Edge(int target, int weight){
            this.target = target;
            this.weight = weight;
        }
    }

    public static Map<Integer, Integer> dijkstraGraph(Map<Integer, List<Edge>> graph, int start){
        Map<Integer, Integer> distances = new HashMap<>();
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        Set<Integer> visited = new HashSet<>();
        for(int node : graph.keySet()){
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0);
        priorityQueue.offer(new int[]{start, 0});
        while (!priorityQueue.isEmpty()){
            int[] current = priorityQueue.poll();
            int node = current[0];
            int currentDistance = current[1];
            if(visited.contains(node)){
                continue;
            }
            visited.add(node);

            for(Edge edge : graph.getOrDefault(node, new ArrayList<>())){
                if(!visited.contains(edge.target)){
                    int newDistance = currentDistance + edge.weight;
                    if(newDistance < distances.get(edge.target)){
                        distances.put(edge.target, newDistance);
                        priorityQueue.offer(new int[]{edge.target, newDistance});
                    }
                }
            }
        }
        return distances;
    }

    public static void main(String[] args){
        Map<Integer, List<Edge>> graph = new HashMap<>();
        graph.put(0, Arrays.asList(new Edge(1,7), new Edge(2,9), new Edge(5, 14)));
        graph.put(1, Arrays.asList(new Edge(0,7), new Edge(2,10), new Edge(3, 15)));
        graph.put(2, Arrays.asList(new Edge(0,9), new Edge(1,10), new Edge(3, 11), new Edge(5,2)));
        graph.put(3, Arrays.asList(new Edge(1,15), new Edge(2,11), new Edge(4, 6)));
        graph.put(4, Arrays.asList(new Edge(3,6), new Edge(5,9)));
        graph.put(5, Arrays.asList(new Edge(0,14), new Edge(2,2), new Edge(4, 9)));

        int startNode = 0;
        Map<Integer, Integer> shortestPaths = dijkstraGraph(graph, startNode);

        System.out.println("Кратчайшие пути отвершины "+startNode + ":");
        for(Map.Entry<Integer, Integer> entry: shortestPaths.entrySet()){
            System.out.println("До вершины "+entry.getKey() + " = " + entry.getValue());
        }

    }
}
