package org.example;

import java.util.ArrayList;
import java.util.List;

public class SearchVisitor implements FileSystemVisitor{
    private List<File> foundFiles = new ArrayList<>();
    private String pattern;

    public SearchVisitor(String pattern){
        this.pattern = pattern;
    }
    @Override
    public void visit(File file){
        if (file.getName().contains(pattern)){
            foundFiles.add(file);
        }
    }
    @Override
    public void visit(Directory directory) {
        // Not used for searching
    }

    public List<File> getFoundFiles() {
        return foundFiles;
    }
}
