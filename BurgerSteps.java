import java.util.*;

public class BurgerSteps {

    static Map<String, List<String>> graph = new HashMap<>();

    static void addEdge(String from, String to) {
        graph.computeIfAbsent(from, k -> new ArrayList<>()).add(to);
    }

        static void bfs(String start) {
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);

        System.out.println("=== BFS (Langkah Berdekatan Dulu) ===");
        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println(current);

            if (graph.containsKey(current)) {
                for (String neighbor : graph.get(current)) {
                    if (!visited.contains(neighbor)) {
                        visited.add(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

   
    static void dfs(String current, Set<String> visited) {
        visited.add(current);
        System.out.println(current);

        if (graph.containsKey(current)) {
            for (String neighbor : graph.get(current)) {
                if (!visited.contains(neighbor)) {
                    dfs(neighbor, visited);
                }
            }
        }
    }

    public static void main(String[] args) {
        addEdge("preheat oven", "bake bread");
        addEdge("preheat oven", "preheat pan");
        addEdge("bake bread", "serve bread");
        

        addEdge("preheat pan", "add krabby patty");
        addEdge("add krabby patty", "add tartar sauce");
        addEdge("add tartar sauce", "pour sauce over patty");
        addEdge("pour sauce over patty", "eat");

        addEdge("add krabby patty", "serve patty");
        addEdge("serve patty", "pour sauce over patty");

        addEdge("preheat pan", "set plate");
        addEdge("set plate", "add some pickles");
        

        addEdge("set plate", "serve patty");
        addEdge("serve bread", "set plate"); 
        addEdge("serve bread", "eat");
        addEdge("add some pickles", "eat");
        addEdge("pour sauce over patty", "eat");


        System.out.println();
        bfs("preheat oven");

        System.out.println();
        System.out.println("=== DFS (Langkah Menjauh Dulu) ===");
        Set<String> visitedDFS = new HashSet<>();
        dfs("preheat oven", visitedDFS);
    }
}
