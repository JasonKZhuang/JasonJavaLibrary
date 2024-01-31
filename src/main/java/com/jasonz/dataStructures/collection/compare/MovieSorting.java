package com.jasonz.dataStructures.collection.compare;

import com.jasonz.dto.Movie;
import com.jasonz.dto.MovieManager;

import java.util.Collections;
import java.util.List;

public class MovieSorting {

    public static void main(String[] args) {
        List<Movie> list = MovieManager.getMovies();

        // Sort by rating :
        // (1) Create an object of ratingCompare
        // (2) Call Collections.sort
        // (3) Print Sorted list
        System.out.println("Sorted by rating");
        CompareMoviesByRating compareMoviesByRating = new CompareMoviesByRating();
        list.sort(compareMoviesByRating);
        for (Movie movie : list) {
            System.out.println(movie.getRating() + " " + movie.getName() + " " + movie.getYear());
        }

        // Call overloaded sort method with RatingCompare
        // (Same three steps as above)
        System.out.println("\nSorted by name");
        CompareMoviesByName compareMoviesByName = new CompareMoviesByName();
        list.sort(compareMoviesByName);
        for (Movie movie : list) {
            System.out.println(movie.getName() + " " + movie.getRating() + " " + movie.getYear());
        }
        // Uses Comparable to sort by year
        System.out.println("\nSorted by year");
        Collections.sort(list);
        for (Movie movie : list) {
            System.out.println(movie.getYear() + " " + movie.getRating() + " " + movie.getName() + " ");
        }
    }
}
