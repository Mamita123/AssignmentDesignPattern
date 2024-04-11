package org.example;

public interface FileSystemElement {
    void accept(FileSystemVisitor visitor);
}
