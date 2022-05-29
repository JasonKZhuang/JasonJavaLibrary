package com.jasonz.oop.collection;

import lombok.Data;

/**
 * @author : Jason Zhuang
 * @date : 29/5/2022
 * @description :
 */
@Data
public class Movie implements Comparable<Movie> {
    private double rating;
    private String name;
    private int year;
    // Constructor
    public Movie(String nm, double rt, int yr) {
        this.name = nm;
        this.rating = rt;
        this.year = yr;
    }
    // Used to sort movies by year
    public int compareTo(Movie m) {
        return this.year - m.year;
    }
}