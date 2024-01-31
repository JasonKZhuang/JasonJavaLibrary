package com.jasonz.dataStructures.collection.compare;

import com.jasonz.dto.Movie;

import java.util.Comparator;

// Class to compare Movies by year
class CompareMoviesByYear implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        if (m1.getYear() < m2.getYear()) return -1;
        if (m1.getYear() > m2.getYear()) return 1;
        else return 0;
    }
}