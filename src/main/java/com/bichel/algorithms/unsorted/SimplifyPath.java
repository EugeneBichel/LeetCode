package com.bichel.algorithms.unsorted;

/*
Given a string path, which is an absolute path (starting with a slash '/')
to a file or directory in a Unix-style file system,
convert it to the simplified canonical path.

In a Unix-style file system,
a period '.' refers to the current directory,
a double period '..' refers to the directory up a level,
and any multiple consecutive slashes (i.e. '//') are treated as a single slash '/'.
For this problem, any other format of periods such as '...'
are treated as file/directory names.

The canonical path should have the following format:
The path starts with a single slash '/'.
Any two directories are separated by a single slash '/'.
The path does not end with a trailing '/'.
The path only contains the directories on the path from the root directory
to the target file or directory (i.e., no period '.' or double period '..')

Return the simplified canonical path.
 */

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String directory : components) {

            if (directory.equals(".") || directory.isEmpty()) {
                continue;
            } else if (directory.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/");
            result.append(dir);
        }

        return result.length() > 0 ? result.toString() : "/" ;
    }
}
