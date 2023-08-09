package com.bichel.algorithms.problemsheap.bfs_dfs;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class DfsConnectedCells2 {
    static int maxRegion(int[][] grid) {
        int nRows = grid.length;
        int nColumns = grid[0].length;

        class GridItem {
            int row;
            int column;
            boolean isOne = false;
            boolean visited = false;
            Set<GridItem> adj;

            public GridItem(int row, int column) {
                this.row = row;
                this.column = column;
                adj = new HashSet<>();
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;

                GridItem gridItem = (GridItem) o;

                if (row != gridItem.row) return false;
                return column == gridItem.column;
            }

            @Override
            public int hashCode() {
                int result = row;
                result = 31 * result + column;
                return result;
            }
        }

        List<GridItem> groups = new ArrayList<>();

        for(int i = 0; i < nRows; i++) {
            for(int j = 0; j < nColumns; j++) {
                if(grid[i][j] == 1) {
                    GridItem newItem = new GridItem(i, j);
                    boolean hasFound = false;

                    for (GridItem head : groups) {
                        if(head.adj.contains(newItem)) {
                            hasFound = true;
                            break;
                        } else if (head.adj.contains(new GridItem(newItem.row - 1, newItem.column)) ||
                                head.adj.contains(new GridItem(newItem.row - 1, newItem.column - 1)) ||
                                head.adj.contains(new GridItem(newItem.row, newItem.column - 1)) ||
                                head.adj.contains(new GridItem(newItem.row, newItem.column + 1)) ||
                                head.adj.contains(new GridItem(newItem.row - 1, newItem.column + 1)) ||
                                head.adj.contains(new GridItem(newItem.row + 1, newItem.column + 1)) ||
                                head.adj.contains(new GridItem(newItem.row + 1, newItem.column)) ||
                                head.adj.contains(new GridItem(newItem.row + 1, newItem.column - 1))) {

                            head.adj.add(newItem);
                            hasFound = true;
                            break;
                        }
                    }

                    if(!hasFound) {
                        newItem.adj.add(newItem);

                        LinkedList<GridItem> queue = new LinkedList<>();
                        queue.push(newItem);

                        while(!queue.isEmpty()) {

                            GridItem currItem = queue.pop();
                            for (int i2 = currItem.row; i2 < nRows; i2++) {
                                for (int j2 = currItem.column; j2 < nColumns; j2++) {

                                    if (grid[i2][j2 + 1] == 1) {
                                        queue.add(new GridItem(i2, j2 + 1));
                                    }
                                    if (grid[i2][j2 + 1] == 1) {
                                        queue.add(new GridItem(i2, j2 + 1));
                                    }

                                }
                            }
                        }


                        if( newItem.row > 0 && grid[newItem.row-1][newItem.column] == 1) {
                            newItem.adj.add(new GridItem(newItem.row-1, newItem.column));
                        }
                        if(newItem.row > 0 && newItem.column > 0 && grid[newItem.row-1][newItem.column-1] == 1) {
                            newItem.adj.add(new GridItem(newItem.row-1, newItem.column-1));
                        }
                        if(newItem.column > 0 && grid[newItem.row][newItem.column-1] == 1) {
                            newItem.adj.add(new GridItem(newItem.row, newItem.column-1));
                        }
                        if(newItem.column < nColumns-1 && grid[newItem.row][newItem.column+1] == 1) {
                            newItem.adj.add(new GridItem(newItem.row, newItem.column+1));
                        }
                        if( newItem.row > 0 && newItem.column < nColumns-1 && grid[newItem.row-1][newItem.column+1] == 1) {
                            newItem.adj.add(new GridItem(newItem.row-1, newItem.column+1));
                        }
                        if( newItem.row < nRows-1 && newItem.column < nColumns-1 && grid[newItem.row+1][newItem.column+1] == 1) {
                            newItem.adj.add(new GridItem(newItem.row+1, newItem.column+1));
                        }
                        if( newItem.row < nRows-1 && grid[newItem.row+1][newItem.column] == 1) {
                            newItem.adj.add(new GridItem(newItem.row+1, newItem.column));
                        }
                        if( newItem.row < nRows-1 && newItem.column > 0 && grid[newItem.row+1][newItem.column-1] == 1) {
                            newItem.adj.add(new GridItem(newItem.row+1, newItem.column-1));
                        }

                        groups.add(newItem);
                    }
                }
            }
        }

        List<Integer> sizes = new ArrayList<>();

        for(int i = 0; i < groups.size(); i++) {
            sizes.add(groups.get(i).adj.size());
        }

        Collections.sort(sizes);

        return sizes.get(sizes.size()-1);
    }
}
