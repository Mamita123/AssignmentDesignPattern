package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create directory structure
        Directory root = new Directory("root");
        Directory folder1 = new Directory("folder1");
        Directory folder2 = new Directory("folder2");
        File file1 = new File("file1.txt", 5);
        File file2 = new File("file2.pdf", 10);
        File file3 = new File("file3.txt", 8);

        root.addElement(folder1);
        root.addElement(folder2);
        folder1.addElement(file1);
        folder1.addElement(file2);
        folder2.addElement(file3);

        // Use visitors
        SizeCalculatorVisitor sizeVisitor = new SizeCalculatorVisitor();
        root.accept(sizeVisitor);
        System.out.println("Total size of all files: " + sizeVisitor.getTotalSize() + " MB");

        SearchVisitor searchVisitor = new SearchVisitor(".txt");
        root.accept(searchVisitor);
        List<File> foundFiles = searchVisitor.getFoundFiles();
        System.out.println("Files with .txt extension:");
        for (File file : foundFiles) {
            System.out.println(file.getName());
        }
    }
}
