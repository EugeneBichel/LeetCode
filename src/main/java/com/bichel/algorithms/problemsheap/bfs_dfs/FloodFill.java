package com.bichel.algorithms.problemsheap.bfs_dfs;

/*
An image is represented by an m x n integer grid image
where image[i][j] represents the pixel value of the image.

You are also given three integers sr, sc, and newColor.
You should perform a flood fill on the image starting
from the pixel image[sr][sc].

To perform a flood fill, consider the starting pixel,
plus any pixels connected 4-directionally to the starting pixel
of the same color as the starting pixel,
plus any pixels connected 4-directionally to those pixels
(also with the same color), and so on.
Replace the color of all of the aforementioned pixels with newColor.

Return the modified image after performing the flood fill.


 */

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    private class Point {
        public int r;
        public int c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        bfs(image, sr, sc,newColor);

        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int newColor) {

        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];

        if(oldColor == newColor) return;

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sr, sc));

        while(!q.isEmpty()) {
            Point p = q.poll();

            image[p.r][p.c] = newColor;

            if(p.r-1 >= 0 && image[p.r-1][p.c] == oldColor) {
                q.add(new Point(p.r-1, p.c));
            }
            if(p.r+1 < rows && image[p.r+1][p.c] == oldColor) {
                q.add(new Point(p.r+1, p.c));
            }
            if(p.c-1 >= 0 && image[p.r][p.c-1] == oldColor) {
                q.add(new Point(p.r, p.c-1));
            }
            if(p.c+1 < cols && image[p.r][p.c+1] == oldColor) {
                q.add(new Point(p.r, p.c+1));
            }
        }

    }
}
