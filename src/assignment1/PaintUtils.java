package assignment1;

/*
    n -> number of rows of bit image
    m -> number of columns of bit image

    The cost of the algorithm in the worst case would be O(n * m)
    because in this case we have to go through all the bits of the
    image and change the color of all of them.
 */
public class PaintUtils {

    public static void changeColor(int[][] image, int x, int y, int newColor, int colorSelected) {
        // Assuming the colors is an integer from 0 -> 255 (for simplicity)
        // image -> 2d array that contains the pixels of the whole image
        // x, y -> Exact point of the image in which the user click to change the color
        // newColor -> New color to use
        // colorSelected -> It is the color of the pixel that the user has just clicked

        /*
            At this point we must call a function that changes the color not
            only of the concrete point, but also of all points. of the concrete
            point, but it has to change the color of all the surrounding points
            surrounding it until the first limit or edge that would be the box
            that is the structure of the house. the structure of the house.
            We can imagine that the limits-frontiers are in black (0) or in
            short, any color that is different from the one that the user has
            clicked. The problem could be solved with a recursive function
            like this one
         */

        // If we reach the limits of the image, we exit the function
        if(x < 0 || y < 0 || x > image.length - 1 || y > image[x].length - 1) return;
        // If we reach a different color than the user just clicked on,
        // we exit the function.
        if (image[x][y] != colorSelected) return;

        // Paint the point (bit) where we are with the new color.
        image[x][y] = newColor;
        // Call again to the function for each adjacent point (bit)
        changeColor(image,x + 1, y, newColor, colorSelected);
        changeColor(image, x, y + 1, newColor, colorSelected);
        changeColor(image, x - 1, y, newColor, colorSelected);
        changeColor(image, x, y - 1, newColor, colorSelected);

    }

}
