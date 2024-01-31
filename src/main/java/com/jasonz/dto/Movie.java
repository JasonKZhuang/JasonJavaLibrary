package com.jasonz.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author : Jason Zhuang
 * @date : 29/5/2022
 * @description :
 */
@Data
@Builder
public class Movie implements Comparable<Movie> {
    private final int id;
    private final String name;
    private final double rating;
    private final int year;

    // Used to sort movies by year
    @Override
    public int compareTo(Movie m) {
        return this.year - m.year;
    }
}