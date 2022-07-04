package assignment2;

import java.util.*;

// Build the graph receiving a matrix or an adjList,
// but my graph is going to be represented by an adjList
// to be more efficient.

// TODO explain how I resolve the problem and the cost
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

    // DFS search adapted to know if the graph is cyclic
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
