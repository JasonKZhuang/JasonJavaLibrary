package com.jasonz.dataStructures.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jason Zhuang
 * @created 2023.11.17 14:54
 * @project JasonJavaLibrary
 * @description:
 */
public class MovieUtils {

    public static List<Movie> getMovies(){
        List<Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Force Awakens", 8.3, 2015));
        movies.add(new Movie(2, "Star Wars", 8.7, 1977));
        movies.add(new Movie(3, "Empire Strikes Back", 8.8, 1980));
        movies.add(new Movie(4, "Return of the Jedi", 8.4, 1983));
        return movies;
    }
}
