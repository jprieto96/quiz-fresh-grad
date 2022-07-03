package assignment2;

import assignment1.PaintUtils;

public class Main {

    public static void main(String[] args) {
        int[][] image = {{0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0}};
        PaintUtils.changeColor(image, 4, 2, 255);
    }

}
