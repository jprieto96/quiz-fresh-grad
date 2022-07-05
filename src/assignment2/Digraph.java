package assignment2;

import java.util.*;

/*
    To solve each of the points of the assignment I have used a digraph with two constructors,
    one of them to build the graph with a matrix and the other to build the graph with an
    adjacency list. However, the digraph that I am going to build in memory will always use an
    adjacency list to be more efficient.

    To detect if the graph is cyclic I go through the graph with DFS, and additionally I use
    a boolean vector to know the parents of the current node invoked in the current call
    to the function, in case one of these nodes has already been visited the graph will be
    cyclic.

    Assuming that the graph represents dependencies between the nodes, we can use the
    topological order to extract the dependencies of each of the nodes of the graph.
    To get the topological order we can also use DFS and additionally use a linked list to
    put each of the nodes at its corresponding point in time, which is once all its children
    have been explored.

    The cost of DFS in the case of using an adjacency matrix would have been O(V^2) since
    in order to know all the edges, we must traverse the entire matrix which is of
    size V x V.

    In this case I have used an adjacency list to gain efficiency and the DFS cost would
    be O(V + E) since in the worst case we have to traverse all vertices only once added
    to their edges.

 */

public class Digraph {

    private int V;
    private List<List<Integer>> adjList;

    private boolean isCyclic;

    // Build digraph with adjacency matrix
    public Digraph(boolean[][] adjMatrix) {
        this.V = adjMatrix.length;
        adjList = new ArrayList<>();
        for(int i = 0; i < adjMatrix.length; i++) {
            List<Integer> auxList = new ArrayList<>();
            for(int j = 0; j < adjMatrix[i].length; j++) {
                if(i != j && adjMatrix[i][j])
                    auxList.add(j);
            }
            adjList.add(auxList);
        }
    }

    // Build digraph with adjacency list
    public Digraph(List<List<Integer>> adjList) {
        this.V = adjList.size();
        this.adjList = adjList;
    }

    // DFS search
    private void dfs(int v, boolean[] visited, boolean[] recursion, LinkedList<Integer> solution) {
        visited[v] = true;
        recursion[v] = true;

        List<Integer> children = adjList.get(v);
        for (Integer w : children) {
            if(isCyclic) return;
            if(!visited[w]) {
                dfs(w, visited, recursion, solution);
            }
            else if(recursion[w]) {
                isCyclic = true;
            }
        }

        solution.addLast(v);
        recursion[v] = false;
    }

    public void printSolution() {
        boolean visited[] = new boolean[V];
        boolean recursion[] = new boolean[V];
        LinkedList<Integer> solution = new LinkedList<>();

        for(int v = 0; v < V; v++) {
            if(!visited[v] && !isCyclic) {
                dfs(v, visited, recursion, solution);
            }
        }

        if(isCyclic) {
            System.out.println("Cycled detected");
        }
        else {
            for(Integer v : solution) {
                System.out.print(v + " ");
            }
        }

    }

}
