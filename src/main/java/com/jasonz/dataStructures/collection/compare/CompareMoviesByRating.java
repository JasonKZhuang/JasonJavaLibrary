package com.jasonz.dataStructures.collection.compare;

import com.jasonz.dto.Movie;

import java.util.Comparator;

// Class to compare Movies by ratings
class CompareMoviesByRating implements Comparator<Movie> {
    public int compare(Movie m1, Movie m2) {
        if (m1.getRating() < m2.getRating()) return -1;
        if (m1.getRating() > m2.getRating()) return 1;
        else return 0;
    }
}