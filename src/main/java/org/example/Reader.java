package org.example;

public interface Reader<T> {
    void read(String targetPath, BuilderFunc<T> builderFunc);
}
