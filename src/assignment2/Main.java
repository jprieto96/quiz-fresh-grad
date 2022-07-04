package assignment2;

import java.util.ArrayList;
import java.util.List;

public class Main {

    // Adj Matrix
    private static boolean[][] matrix = new boolean[7][7];

    // Adj List
    private static List<List<Integer>> adjList = new ArrayList<>();

    public static void main(String[] args) {

        System.out.println("---------------------- Input 1 ----------------------");

        // Input 1 (matrix)
        matrix = new boolean[7][7];
        matrix[0][6] = true;
        matrix[1][0] = true;
        matrix[2][1] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;
        matrix[5][3] = true;
        matrix[6][0] = true;

        System.out.println("-----> Adjacency matrix as the input ");
        System.out.print("Expected output: ");
        Digraph sol1A = new Digraph(matrix);
        sol1A.printSolution();

        System.out.println();

        // Input 1 (list)
        adjList = new ArrayList<>();
        List<Integer> auxList = new ArrayList<>();
        auxList.add(1);
        auxList.add(6);
        adjList.add(auxList);
        auxList = new ArrayList<>();
        auxList.add(2);
        adjList.add(auxList);
        auxList = new ArrayList<>();
        auxList.add(3);
        adjList.add(auxList);
        auxList = new ArrayList<>();
        auxList.add(4);
        auxList.add(5);
        adjList.add(auxList);
        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>());
        auxList = new ArrayList<>();
        auxList.add(0);
        adjList.add(auxList);

        System.out.println("-----> Adjacency list as the input");
        System.out.print("Expected output: ");
        Digraph sol1B = new Digraph(adjList);
        sol1B.printSolution();

        System.out.println();
        System.out.println();

        System.out.println("---------------------- Input 2 ----------------------");

        // Input 2 (matrix)
        matrix = new boolean[7][7];
        matrix[0][6] = true;
        matrix[1][0] = true;
        matrix[2][1] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;
        matrix[5][3] = true;

        System.out.println("-----> Adjacency matrix as the input");
        System.out.print("Expected output: ");
        Digraph sol2A = new Digraph(matrix);
        sol2A.printSolution();

        System.out.println();

        // Input 2 (list)
        adjList = new ArrayList<>();
        auxList = new ArrayList<>();
        auxList.add(1);
        adjList.add(auxList);
        auxList = new ArrayList<>();
        auxList.add(2);
        adjList.add(auxList);
        auxList = new ArrayList<>();
        auxList.add(3);
        adjList.add(auxList);
        auxList = new ArrayList<>();
        auxList.add(4);
        auxList.add(5);
        adjList.add(auxList);
        adjList.add(new ArrayList<>());
        adjList.add(new ArrayList<>());
        auxList = new ArrayList<>();
        auxList.add(0);
        adjList.add(auxList);

        System.out.println("-----> Adjacency list as the input");
        System.out.print("Expected output: ");
        Digraph sol2B = new Digraph(adjList);
        sol2B.printSolution();

    }

}
