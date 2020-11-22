package edu;

import java.util.Arrays;

public class PlayRoom {
    public static void main(String[] args) {
        Game.GameDisk[] disk = new Game.GameDisk[4];
        disk[0] = Game.getDisk("God of War", Genre.ACTION, "Классная игрушка");
        disk[1] = Game.getDisk("Tekken", Genre.SPORT, "Ностальгия");
        disk[2] = Game.getDisk("Fable", Genre.ADVENTURES, "Хорошая игрушка");
        disk[3] = Game.getDisk("Darksiders", Genre.ADVENTURES, "Неплохая игрушка");

        Game.VirtualGame[] netGames = new Game.VirtualGame[4];
        netGames[0] = Game.getVirtualGame("some name1", Genre.RACE);
        netGames[1] = Game.getVirtualGame("some name2", Genre.SPORT);
        netGames[2] = Game.getVirtualGame("some name3", Genre.ACTION);
        netGames[3] = Game.getVirtualGame("some name4", Genre.ADVENTURES);

        GameConsole console = new GameConsole("Sony Playstation", "#13141341");
        GenreComparator comparator = new GenreComparator();
        Arrays.sort(disk, comparator);
        for (int i = 0; i < disk.length; i++) {
            System.out.println(disk[i].getData().getGenre());
        }



    }
}
