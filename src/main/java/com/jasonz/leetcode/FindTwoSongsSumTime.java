package com.jasonz.leetcode;
/*
We have a catalog of song titles (and their lengths) that we play at a local radio station.  We have been asked to play two of those songs in a row, and they must add up to exactly seven minutes long.

Given a list of songs and their durations, write a function that returns the names of any two distinct songs that add up to exactly seven minutes.  If there is no such pair, return an empty collection.

Example:
song_times_1 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Good Times Bad Times", "2:48"), ("Hot Dog", "3:19"),
    ("The Crunge", "3:18"), ("Achilles Last Stand", "10:26"),
    ("Black Dog", "4:55")
]
find_pair(song_times_1) => ["Rock and Roll", "Hot Dog"] (3:41 + 3:19 = 7:00)

Additional Input:
song_times_2 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Good Times Bad Times", "2:48"), ("Black Dog", "4:55"),
    ("The Crunge", "3:18"), ("Achilles Last Stand", "10:26"),
    ("The Ocean", "4:31"), ("Hot Dog", "3:19"),
]
song_times_3 = [
    ("Stairway to Heaven", "8:05"), ("Immigrant Song", "2:27"),
    ("Rock and Roll", "3:41"), ("Communication Breakdown", "2:29"),
    ("Hey Hey What Can I Do", "4:00"), ("Poor Tom", "3:00"),
    ("Black Dog", "4:55")
]
song_times_4 = [
    ("Hey Hey What Can I Do", "4:00"), ("Rock and Roll", "3:41"),
    ("Communication Breakdown", "2:29"), ("Going to California", "3:30"),
    ("On The Run", "3:50"), ("The Wrestler", "3:50"),
    ("Black Mountain Side", "2:00"), ("Black Dog", "4:55")
]
song_times_5 = [("Celebration Day", "3:30"), ("Going to California", "3:30")]
song_times_6 = [
  ("Rock and Roll", "3:41"), ("If I lived here", "3:59"),
  ("Day and night", "5:03"), ("Tempo song", "1:57")
]


Complexity Variable:
n = number of song/time pairs

All Test Cases - snake_case:
find_pair(song_times_1) => ["Rock and Roll", "Hot Dog"]
find_pair(song_times_2) => ["Rock and Roll", "Hot Dog"] or ["Communication Breakdown", "The Ocean"]
find_pair(song_times_3) => ["Hey Hey What Can I Do", "Poor Tom"]
find_pair(song_times_4) => []
find_pair(song_times_5) => ["Celebration Day", "Going to California"]
find_pair(song_times_6) => ["Day and night", "Tempo song"]

All Test Cases - camelCase:
findPair(songTimes1) => ["Rock and Roll", "Hot Dog"]
findPair(songTimes2) => ["Rock and Roll", "Hot Dog"] or ["Communication Breakdown", "The Ocean"]
findPair(songTimes3) => ["Hey Hey What Can I Do", "Poor Tom"]
findPair(songTimes4) => []
findPair(songTimes5) => ["Celebration Day", "Going to California"]
findPair(songTimes6) => ["Day and night", "Tempo song"]

*/


import lombok.Getter;
import lombok.Setter;

import java.util.*;

public class FindTwoSongsSumTime {
    public static void main(String[] argv) {

        String[][] songTimes1 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Hot Dog", "3:19"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"Black Dog", "4:55"}
        };
        String[][] songTimes2 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Good Times Bad Times", "2:48"}, {"Black Dog", "4:55"},
                {"The Crunge", "3:18"}, {"Achilles Last Stand", "10:26"},
                {"The Ocean", "4:31"}, {"Hot Dog", "3:19"}
        };
        String[][] songTimes3 = {
                {"Stairway to Heaven", "8:05"}, {"Immigrant Song", "2:27"},
                {"Rock and Roll", "3:41"}, {"Communication Breakdown", "2:29"},
                {"Hey Hey What Can I Do", "4:00"}, {"Poor Tom", "3:00"},
                {"Black Dog", "4:55"}
        };
        String[][] songTimes4 = {
                {"Hey Hey What Can I Do", "4:00"}, {"Rock and Roll", "3:41"},
                {"Communication Breakdown", "2:29"}, {"Going to California", "3:30"},
                {"On The Run", "3:50"}, {"The Wrestler", "3:50"},
                {"Black Mountain Side", "2:00"}, {"Black Dog", "4:55"}
        };
        String[][] songTimes5 = {
                {"Celebration Day", "3:30"}, {"Going to California", "3:30"}
        };
        String[][] songTimes6 = {
                {"Rock and Roll", "3:41"},
                {"If I lived here", "3:59"},
                {"Day and night", "5:03"},
                {"Tempo song", "1:57"}
        };

        FindTwoSongsSumTime ins = new FindTwoSongsSumTime();


        System.out.println(Arrays.toString(ins.solutionByArrayListAndTwoPointers(songTimes1)));
        System.out.println(Arrays.toString(ins.solutionByArrayListAndTwoPointers(songTimes2)));
        System.out.println(Arrays.toString(ins.solutionByArrayListAndTwoPointers(songTimes3)));
        System.out.println(Arrays.toString(ins.solutionByArrayListAndTwoPointers(songTimes4)));
        System.out.println(Arrays.toString(ins.solutionByArrayListAndTwoPointers(songTimes5)));
        System.out.println(Arrays.toString(ins.solutionByArrayListAndTwoPointers(songTimes6)));
    }
    private static int convertSeconds(String argTime) {
        String[] myTime = argTime.split(":");
        int mins = Integer.parseInt(myTime[0]) * 60;
        int secs = Integer.parseInt(myTime[1]);
        return mins + secs;

    }

    private String[] solutionByArrayListAndTwoPointers(String[][] array) {

        String[] ret = new String[2];
        // key is seconds, value is song
        ArrayList<Song> songs = new ArrayList<>();
        for (String[] tempSong : array) {
            Song song = new Song(tempSong[0], tempSong[1]);
            songs.add(song);
        }

        songs.sort(new Comparator<Song>() {
            @Override
            public int compare(Song o1, Song o2) {
                return Integer.compare(o1.getSeconds(), o2.getSeconds());
            }
        });

        int n = songs.size();
        int l = 0;
        int r = n - 1;


        // Display elements
        while (l < n && r >0  && l < r) {
            Song sLeft = songs.get(l);
            Song sRight = songs.get(r);
            int sumSeconds = sLeft.getSeconds() + sRight.getSeconds();

            if (sumSeconds == 7 * 60) {
                ret[0] = songs.get(l).getName();
                ret[1] = songs.get(r).getName();
                return ret;
            } else if (sumSeconds < 7 * 60) {
                l = l + 1;
            } else {
                r = r - 1;
            }
        }
        return ret;
    }

    @Getter
    @Setter
    private static class Song {
        String name;
        int seconds;

        public Song(String argName, String argTime) {
            this.name = argName;
            this.seconds = convertSeconds(argTime);
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSeconds(int seconds) {
            this.seconds = seconds;
        }
    }
}
