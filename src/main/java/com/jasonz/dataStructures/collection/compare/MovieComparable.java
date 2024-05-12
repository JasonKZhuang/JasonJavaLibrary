// Lesson6Distinct Java program to demonstrate use of Comparable
package com.jasonz.dataStructures.collection.compare;


import com.jasonz.dto.Movie;
import com.jasonz.dto.MovieManager;

import java.util.Collections;
import java.util.List;

// Driver class
class MovieComparable {

    public static void main(String[] args) {
        List<Movie> list = MovieManager.getMovies();
        Collections.sort(list);
        System.out.println("Movies after sorting : ");
        for (Movie movie : list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
    }

}
