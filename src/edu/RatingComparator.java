package edu;

import java.util.Comparator;

public class RatingComparator implements Comparator<Game.VirtualGame> {

    @Override
    public int compare(Game.VirtualGame o1, Game.VirtualGame o2) {
        return o1.getRating();

    }
}
