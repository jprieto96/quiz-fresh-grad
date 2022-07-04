package assignment2;

public class Main {

    public static void main(String[] args) {

        // Input 1 (matrix)
        boolean[][] matrix = new boolean[7][7];
        matrix[0][6] = true;
        matrix[1][0] = true;
        matrix[2][1] = true;
        matrix[3][2] = true;
        matrix[4][3] = true;
        matrix[5][3] = true;
        matrix[6][0] = true;

        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        Digraph digraph = new Digraph(matrix);
        digraph.print();
    }

}
