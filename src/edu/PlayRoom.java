package edu;

import java.util.Arrays;
/*3.  Создать класс PlayRoom
        •  Создать main метод.
        •  Создать массив с играми на физ. носителях (4 игры). (пользуемся методом
        getDisk)
        •  Создать массив с играми из виртуального магазина (4 игры). (пользуемся
        методом getVirtualGame)
        •  Создать GameConsole.*/

public class PlayRoom {
    public static void main(String[] args) {
        Game.GameDisk[] disk = new Game.GameDisk[4];
        disk[0] = Game.getDisk("God of War", Genre.ACTION, "Классная игрушка");
        disk[1] = Game.getDisk("Tekken", Genre.SPORT, "Ностальгия");
        disk[2] = Game.getDisk("Fable", Genre.ADVENTURES, "Хорошая игрушка");
        disk[3] = Game.getDisk("Darksiders", Genre.ADVENTURES, "Неплохая игрушка");

        Game.VirtualGame[] netGames = new Game.VirtualGame[4];
        netGames[0] = Game.getVirtualGame("some name1", Genre.RACE, 5);
        netGames[1] = Game.getVirtualGame("some name2", Genre.SPORT, 2);
        netGames[2] = Game.getVirtualGame("some name3", Genre.ACTION, 3);
        netGames[3] = Game.getVirtualGame("some name4", Genre.ADVENTURES, 4);

        GameConsole console = new GameConsole("Sony Playstation", "#13141341");
//        •  В методе main, отсортировать массив с физическими дисками по жанру
        GenreComparator comparator = new GenreComparator();
        Arrays.sort(disk, comparator);
        for (int i = 0; i < disk.length; i++) {
            System.out.println(disk[i].getData().getGenre());
        }
//        •  В методе main, отсортировать массив с виртуальными играми по рейтингу.
        RatingComparator ratingComparator = new RatingComparator();
        Arrays.sort(netGames, ratingComparator);
        for (Game.VirtualGame netGame : netGames) {
            System.out.println(netGame.getRating());
        }

        console.loadGame(disk[1].getData());
        int count = 0;
        while (count < 15) {
            console.playGame();
            count++;
        }
    }
}
