package assignment1;

public class Main {

    public static void main(String[] args) {
        // Here you can test my code
        // 0 -> Borders or limits
        // Any other color could be changed to another color
        // We assume that the color just clicked on a bit that has color 255

        /*
            You will see that the entire area painted with 255 is going to be
            painted with 10
         */
        int[][] image = {{0, 0, 0, 0, 0, 0}, {0, 255, 255, 255, 255, 0}, {0, 0, 255, 255, 0, 0}, {0, 255, 255, 255, 255, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};

        System.out.println("---------------- Before ----------------");
        paintImage(image);

        PaintUtils.changeColor(image, 1, 1, 10, 255);

        System.out.println("---------------- After ----------------");
        paintImage(image);

    }

    private static void paintImage(int[][] image) {
        for(int i = 0; i < image.length; i++) {
            for(int j = 0; j < image[i].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

}
