package datastructures;

import java.io.File;

public class FileTree {

    public static void traverse(File root) {
        if (root == null) return;
        System.out.println(root.getName());

        if (root.isDirectory()) {
            for (File f : root.listFiles()) {
                traverse(f);
            }
        }
    }
}
