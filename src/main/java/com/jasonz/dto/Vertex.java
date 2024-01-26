package com.jasonz.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.LinkedList;
import java.util.List;

@Data
@Getter
public class Vertex<T> {
    private final T data;

    @Setter
    private boolean visited;
    @ToString.Exclude
    private List<Vertex<T>> neighbors = new LinkedList<>();
}