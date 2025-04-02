import java.util.*;

public class Graph {

    private Map<Integer, TreeSet<Integer>> adjacencyList;

    public Graph() {
        adjacencyList = new HashMap<>();
    }

    // Adds an undirected edge between source and destination
    public void addEdge(int source, int destination) {
        adjacencyList.computeIfAbsent(source, k -> new TreeSet<>()).add(destination);
        adjacencyList.computeIfAbsent(destination, k -> new TreeSet<>()).add(source);
    }

    // Returns a set of friends (neighbors) for a person, or an empty set if none
    public TreeSet<Integer> getFriends(int personId) {
        return adjacencyList.getOrDefault(personId, new TreeSet<>());
    }

    // Checks if there is a path between source and destination
    public boolean hasConnection(int source, int destination) {
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            TreeSet<Integer> neighbors = adjacencyList.getOrDefault(current, new TreeSet<>());
            for (int neighbor : neighbors) {
                if (neighbor == destination) {
                    return true;
                }
                if (visited.add(neighbor)) {
                    queue.add(neighbor);
                }
            }
        }

        return false;
    }

    // Returns the path (if any) from source to destination
    public List<Integer> getConnectionPath(int source, int destination) {
        Map<Integer, Integer> parentMap = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(source);
        queue.add(source);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            TreeSet<Integer> neighbors = adjacencyList.getOrDefault(current, new TreeSet<>());
            for (int neighbor : neighbors) {
                if (visited.add(neighbor)) {
                    parentMap.put(neighbor, current);
                    if (neighbor == destination) {
                        // Reconstruct connection path
                        List<Integer> path = new ArrayList<>();
                        for (int node = destination; node != source; node = parentMap.get(node)) {
                            path.add(0, node);
                        }
                        path.add(0, source);
                        return path;
                    }
                    queue.add(neighbor);
                }
            }
        }

        return Collections.emptyList();
    }
}
