package com.jasonz.dataStructures.collection.compare;

import com.jasonz.dto.Movie;

import java.util.Comparator;

// Class to compare Movies by name
class CompareMoviesByName implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        return m1.getName().compareTo(m2.getName());
    }
}