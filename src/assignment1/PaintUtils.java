package assignment1;

public class PaintUtils {

    public static void changeColor(int[][] image, int x, int y, int newColor) {
        // Assuming the colors is an integer from 0 -> 255 (for simplicity)
        // image -> 2d array that contains the pixels of the whole image
        // x, y -> Exact point of the image in which the user click to change the color
        // newColor -> New color to use

        // Go through all the image points and change the color
        for(int i = 0; i < image.length; i++){
            for(int j = 0; j < image[i].length; j++){
                if(x == i && y == j) {
                    // Change the color of the shape that surrounds the point.

                    image[x][y] = newColor;
                }
            }
        }
    }

}
