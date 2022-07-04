package assignment2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Build the graph receiving a matrix or an adjList,
// but my graph is going to be represented by an adjList
// to be more efficient.

// I am going to use DFS to solve the problem of detect
// if the graph has cycles
public class Digraph {

    private int V;
    private int A;
    private List<List<Integer>> adjList;

    public Digraph(boolean[][] adjMatrix) {
        this.V = adjMatrix.length;
        this.A = 0;
        adjList = new ArrayList<>();
        for(int i = 0; i < adjMatrix.length; i++) {
            List<Integer> auxList = new ArrayList<>();
            for(int j = 0; j < adjMatrix[i].length; j++) {
                if(adjMatrix[i][j])
                    auxList.add(j);
            }
            adjList.add(auxList);
        }
    }

    public Digraph(List<List<Integer>> adjList) {
        this.V = adjList.size();
        this.A = 0;
        this.adjList = adjList;
    }

    private void dfs(int v, boolean[] visited) {
        visited[v] = true;
        System.out.print(V + " ");

        Iterator<Integer> i = adjList.get(v).listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                dfs(n, visited);
        }
    }

    public void dfs(int v) {
        boolean visited[] = new boolean[V];
        dfs(v, visited);
    }

    public void print() {
        for(int v = 0; v < V; v++) {
            System.out.print(v + ": ");
            for(Integer w : adjList.get(v)){
                System.out.print(w + " ");
                ++A;
            }
            System.out.println();
        }
        System.out.println(V + " vertexes, " + A + " edges");
    }

}
