package edu;

import java.util.Comparator;

public class GenreComparator implements Comparator<Game.GameDisk> {


    @Override
    public int compare(Game.GameDisk o1, Game.GameDisk o2) {
        return o1.getData().getGenre().compareTo(o2.getData().getGenre());
    }
}
