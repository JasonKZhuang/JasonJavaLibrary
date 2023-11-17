package com.jasonz.dataStructures.collection.compare;// A Java program to demonstrate use of Comparable

import com.jasonz.dataStructures.dto.Movie;
import com.jasonz.dataStructures.dto.MovieUtils;

import java.util.Collections;
import java.util.List;

// Driver class
class MovieComparable {
    public static void main(String[] args) {
        List<Movie> list = MovieUtils.getMovies();
        Collections.sort(list);
        System.out.println("Movies after sorting : ");
        for (Movie movie : list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
    }
}
