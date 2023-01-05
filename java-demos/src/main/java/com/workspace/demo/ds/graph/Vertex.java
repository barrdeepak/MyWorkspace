package com.workspace.demo.ds.graph;

import java.util.Objects;

public class Vertex {
    char label;
    Vertex(char label) {
        this.label = label;
    }
    public char getLabel() {
        return label;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vertex vertex = (Vertex) o;
        return label == vertex.label;
    }

    @Override
    public int hashCode() {
        return Objects.hash(label);
    }
}
